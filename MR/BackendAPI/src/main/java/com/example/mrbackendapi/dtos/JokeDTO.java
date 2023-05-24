package com.example.mrbackendapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JokeDTO {
    public JokeDTO() {
    }

    @JsonProperty("url")
    private String url;
    @JsonProperty("value")
    private String joke;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("icon_url")
    private String iconUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }
}
