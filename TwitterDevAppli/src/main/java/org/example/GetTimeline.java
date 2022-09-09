package org.example;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class GetTimeline {
    public static void getTimeline(String apiKey,String apiSec,String accessToken,String accessTokenSec) {


        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSec)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSec);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try{

            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":" +
                        status.getText());
            }
            System.out.println("Successfully updated tweet");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}


