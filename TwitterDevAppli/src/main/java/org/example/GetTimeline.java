package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class GetTimeline {
    public static void getTimeline(String apiKey,String apiSec,String accessToken,String accessTokenSec) {
        Logger logger = LoggerFactory.getLogger(PostTweet.class);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSec)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSec);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try{

            Query query = new Query("Kohli");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }

        }
        catch(Exception e){
            logger.error("{}",e);
        }

    }
}


