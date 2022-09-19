package com.example.springtwitter.Resources;

import com.example.springtwitter.Services.FilterTweet;
import com.example.springtwitter.Services.GetTimeline;
import com.example.springtwitter.Services.PojoReq;
import com.example.springtwitter.Services.PostTweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/1.0/twitter")
public class controller {

    private GetTimeline gettingObj;
    private PostTweet postObj;
    private FilterTweet filterObj;

    private PojoReq pojo;

    @Autowired

    public controller(GetTimeline getTimeline, PostTweet postTweet,FilterTweet getFilterTweets, PojoReq pojoSpecs) throws TwitterException {
        this.gettingObj = getTimeline;
        this.postObj=postTweet;
        this.filterObj=getFilterTweets;
        this.pojo=pojoSpecs;
    }


    @GetMapping("/timeline")
    @Cacheable(cacheNames = "timeline")
    public ArrayList gettingTimeLine() throws IOException {
        ArrayList msg = gettingObj.getTimeL();
        return msg;
    }

    @GetMapping("/timeline/filter")
    @Cacheable(cacheNames = "filter")
    public List<String> gettingFilteredTweets() throws TwitterException {
        List<String> filter = filterObj.getFilterTweets();
        return filter;
    }

    @PostMapping("/tweet")
    public String addItems(@RequestBody String tweet) throws IOException {
        String tweeted = postObj.postTweet(tweet);
        return tweeted;
    }

    @GetMapping("/pojo")
    public ArrayList gettingImageURL() throws IOException {
    ArrayList imageUrl=pojo.pojoSpecs();
    return imageUrl;
    }


}
