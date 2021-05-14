package domainobject;

import main.java.domainobject.Tweet;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    private String username;

    private List<String> followers;

    private List<Tweet> tweets;

    private List<String> validatedTweets;

    public User(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
        this.tweets = new ArrayList<>();
        this.validatedTweets = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<String> getValidatedTweets() {
        return validatedTweets;
    }

    public void setValidatedTweets(List<String> validatedTweets) {
        this.validatedTweets = validatedTweets;
    }
}
