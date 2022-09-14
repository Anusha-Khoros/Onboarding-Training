package com.example.springtwitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GetTimeline {

public static ArrayList<String> getTimeL()throws IOException {
    Logger logger = LoggerFactory.getLogger(GetTimeline.class);
    FileReader keys=new FileReader("/Users/anusha.c/Desktop/Onboarding-Training/springTwitter/src/main/resources/application.properties");
    Properties file=new Properties();
    file.load(keys);
    String apiKey=file.getProperty("apiKey");
    String apiSec=file.getProperty("apiSec");
    String accessToken=file.getProperty("accessToken");
    String accessTokenSec=file.getProperty("accessTokenSec");

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true).setOAuthConsumerKey(apiKey).setOAuthConsumerSecret(apiSec).setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSec);
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
        return  T;
    } catch (Exception var11) {
        logger.error("{}", var11);
        return null;
    }
    }

}



