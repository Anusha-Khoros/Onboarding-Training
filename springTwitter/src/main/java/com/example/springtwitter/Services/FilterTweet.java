package com.example.springtwitter.Services;


import com.example.springtwitter.Configuration.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class FilterTweet extends io.dropwizard.Configuration{
    @Autowired
    private static Config myConfig;


    public List<String> getFilterTweets() throws TwitterException {

        Logger logger = LoggerFactory.getLogger(FilterTweet.class);

        Yaml yaml = new Yaml(new Constructor(Config.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("customer.yml");
        Config obj = yaml.load(inputStream);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(obj.getApiKey())
                .setOAuthConsumerSecret(obj.getApiSec())
                .setOAuthAccessToken(obj.getAccessToken())
                .setOAuthAccessTokenSecret(obj.getAccessTokenSec());
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            List<Status> statuses = twitter.getHomeTimeline();
            List<String> filterTweets = statuses
                    .stream()
                    .filter(s -> s.getText().contains("India"))
                    .map(Status::getText)
                    .collect(Collectors.toList());
            return filterTweets;

        }
        catch (Exception var11){
            logger.error("{}", var11);
            return null;
        }
    }
    }


