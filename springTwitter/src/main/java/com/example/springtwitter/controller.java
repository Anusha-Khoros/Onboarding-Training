package com.example.springtwitter;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("api/1.0/twitter")
public class controller {
    @GetMapping("/timeline")
    public ArrayList gettingTimeLine() throws IOException {
        GetTimeline getObj = new GetTimeline();
        ArrayList msg = getObj.getTimeL();

        return msg;
    }

    @PostMapping("/tweet")
    public String addItems(@RequestBody String tweet) throws IOException {
        PostTweet postObj = new PostTweet();
        String tweeted = postObj.postTweet(tweet);
        return tweeted;
    }
}
