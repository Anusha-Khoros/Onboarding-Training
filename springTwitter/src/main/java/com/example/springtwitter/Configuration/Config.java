package com.example.springtwitter.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Config {
    private String apiKey;
    private String apiSec;
    private String accessToken;
    private String accessTokenSec;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiSec() {
        return apiSec;
    }

    public void setApiSec(String apiSec) {
        this.apiSec = apiSec;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSec() {
        return accessTokenSec;
    }

    public void setAccessTokenSec(String accessTokenSec) {
        this.accessTokenSec = accessTokenSec;
    }
}
