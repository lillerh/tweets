package main.java.domainobject;


import domainobject.Hashtag;
import main.java.domainvalue.Language;

import java.util.List;


public class Tweet {

    private String id;

    private String userId;

    private String text;

    private String location;

    private Language language;

    private List<Hashtag> hashtags;

    public Tweet(String userId, String text, String location, Language language, List<Hashtag> hashtags){
        this.userId = userId;
        this.text = text;
        this.location = location;
        this.language = language;
        this.hashtags = hashtags;
    }

    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
