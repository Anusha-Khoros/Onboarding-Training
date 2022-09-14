package com.example.springtwitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class PostTweet {
    public String postTweet(String tweet) throws IOException {
        Logger logger = LoggerFactory.getLogger(PostTweet.class);
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
            twitter.updateStatus(tweet);
            return "Successfully updated tweet.Check the twitter account to see the post";
        } catch (Exception var11) {
            logger.error("{}", var11);
            return null;
        }

    }
}
