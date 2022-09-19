package com.example.springtwitter.Services;

import com.example.springtwitter.Configuration.Config;
import com.example.springtwitter.models.TwitterGetUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class PojoReq {
    @Autowired
    private static Config myConfig;

    public ArrayList<String> pojoSpecs()throws IOException {

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
            TwitterGetUserInfo info=new TwitterGetUserInfo();
            User user = twitter.showUser(twitter.getId());
            ArrayList<String> pojoInfo=new ArrayList<>();
            System.out.println(twitter.showUser(twitter.getId()));

            info.setMessage(user.getStatus().getText());
            String gettingMessage= info.getMessage();
            pojoInfo.add(gettingMessage);

            info.setTwitterHandle(user.getScreenName());
            String gettingTwitterHandle=info.getTwitterHandle();
            pojoInfo.add(gettingTwitterHandle);

            info.setUserName(user.getName());
            String gettingName=info.getUserName();
            pojoInfo.add(gettingName);

            info.setProfileImageUrl(user.getProfileImageURL());
            String gettingUrl=info.getProfileImageUrl();
            pojoInfo.add(gettingUrl);


            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date createdAtTheDate=user.getCreatedAt();
            String dateToString = df.format(createdAtTheDate);
            info.setCreatedAt(dateToString);
            String gettingCreatedAt= info.getCreatedAt();
            pojoInfo.add(gettingCreatedAt);
            System.out.println(gettingCreatedAt);




            return pojoInfo;
            }



        catch (TwitterException e) {
            throw new RuntimeException(e);
        }

    }


}
