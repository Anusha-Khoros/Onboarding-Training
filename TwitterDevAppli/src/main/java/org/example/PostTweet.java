package org.example;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.Scanner;

public class PostTweet {

    public static void postTweet(String apiKey,String apiSec,String accessToken,String accessTokenSec) {
        System.out.println("Enter the tweet to post");
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
            System.out.println("Successfully updated tweet.\n"+"Check the twitter account to see the post");
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}

