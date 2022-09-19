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
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class PostTweet {
    @Autowired
    private static Config myConfig;
    public String postTweet(String tweet) throws IOException {
        Logger logger = LoggerFactory.getLogger(PostTweet.class);
        /*FileReader keys=new FileReader("/Users/anusha.c/Desktop/Onboarding-Training/springTwitter/src/main/resources/config.yml");
        Properties file=new Properties();
        file.load(keys);
        String apiKey=file.getProperty("apiKey");
        String apiSec=file.getProperty("apiSec");
        String accessToken=file.getProperty("accessToken");
        String accessTokenSec=file.getProperty("accessTokenSec");*/

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
            twitter.updateStatus(tweet);
            return "Successfully updated tweet.Check the twitter account to see the post";
        } catch (Exception var11) {
            logger.error("{}", var11);
            return null;
        }

    }
}
