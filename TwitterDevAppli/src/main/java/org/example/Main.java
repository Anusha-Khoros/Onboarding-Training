package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException{
        FileReader keys=new FileReader("/Users/anusha.c/Desktop/Onboarding-Training/TwitterDevAppli/src/main/java/org/example/twitter4j.properties");
        Properties file=new Properties();
        file.load(keys);
        String apiKey=file.getProperty("apiKey");
        String apiSec=file.getProperty("apiSec");
        String accessToken=file.getProperty("accessToken");
        String accessTokenSec=file.getProperty("accessTokenSec");
        Scanner sc=new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("Enter the choice : ");
            System.out.println("1. Post a tweet");
            System.out.println("2. Getting a timeline");
            System.out.println("3. Exit");
            int choice=sc.nextInt();
            if(choice==3){
                break;
            }
            switch(choice){
                case 1: PostTweet postObject= new PostTweet();
                    postObject.postTweet(apiKey,apiSec,accessToken,accessTokenSec);
                    break;
                case 2: GetTimeline timelineObject= new GetTimeline();
                    timelineObject.getTimeline(apiKey,apiSec,accessToken,accessTokenSec);
                    break;
                default:System.out.println("wrong choice");
                    break;
            }
        }
    }
}