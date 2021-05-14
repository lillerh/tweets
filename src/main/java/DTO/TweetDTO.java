package DTO;

import domainobject.Hashtag;
import main.java.domainvalue.Language;

import java.util.List;

public class TweetDTO {

    private String id;

    private UserDTO user;

    private String text;

    private String location;

    private List<UserDTO> tweetValidators;

    private Language language;

    private List<Hashtag> hashtags;

    public TweetDTO() {
    }

    public TweetDTO(String id, UserDTO user, String text, String location, List<UserDTO> tweetValidators) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.location = location;
        this.tweetValidators = tweetValidators;
    }

    public UserDTO getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public String getLocation() {
        return location;
    }

    public Language getLanguage() {
        return language;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public List<UserDTO> getTweetValidators() {
        return tweetValidators;
    }

    public static TweetDTOBuilder newBuilder()
    {
        return new TweetDTOBuilder();
    }

    public static class TweetDTOBuilder{

        private String id;
        private UserDTO user;
        private String text;
        private String location;
        private List<UserDTO> tweetValidators;

        public TweetDTOBuilder setId(String id)
        {
            this.id = id;
            return this;
        }

        public TweetDTOBuilder setUser(UserDTO user)
        {
            this.user = user;
            return this;
        }

        public TweetDTOBuilder setText(String text)
        {
            this.text = text;
            return this;
        }

        public TweetDTOBuilder setLocation(String location)
        {
            this.location = location;
            return this;
        }

        public TweetDTOBuilder setTweetValidators(List<UserDTO> tweetsValidators)
        {
            this.tweetValidators = tweetsValidators;
            return this;
        }

        public TweetDTO createTweetDTO()
        {
            return new TweetDTO(id, user, text, location, tweetValidators);
        }

    }
}
