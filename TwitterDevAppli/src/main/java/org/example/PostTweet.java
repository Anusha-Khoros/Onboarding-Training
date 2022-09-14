package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.Scanner;

public class PostTweet {

    public static void postTweet(String apiKey,String apiSec,String accessToken,String accessTokenSec) {
        Logger logger = LoggerFactory.getLogger(PostTweet.class);
        logger.info("Enter the tweet to post");

        Scanner sc = new Scanner(System.in);
        String tweet= sc.nextLine();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSec)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSec);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try{
            twitter.updateStatus(tweet);

            logger.info("Successfully updated tweet.\n"+"Check the twitter account to see the post");

        }
        catch(Exception e){
            logger.error("{}",e);

        }

    }
}

