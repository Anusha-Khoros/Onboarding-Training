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
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties

public class GetTimeline extends io.dropwizard.Configuration {
    @Autowired
    private static Config myConfig;




public List<Status> getTimeL()throws IOException {

    Logger logger = LoggerFactory.getLogger(GetTimeline.class);
   /* FileReader keys=new FileReader("/Users/anusha.c/Desktop/Onboarding-Training/springTwitter/src/main/resources/config.yml");
    Properties file=new Properties();
    file.load(keys);*/

   // String apiKey=env.getProperty("apiKey");
   // String apiSec=env.getProperty("apiSec");
    //String accessToken=env.getProperty("accessToken");
    //String accessTokenSec=env.getProperty("accessTokenSec");

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
        logger.info("Showing home timeline.");
        ArrayList<String> T=new ArrayList<>();
        for (Status status : statuses) {
            logger.info(status.getUser().getName() );
            T.add(status.getText());
        }
        return  statuses;
    } catch (Exception var11) {
        logger.error("{}", var11);
        return null;
    }
    }


}



