package DTO;

import java.util.List;

public class UserDTO {

    private String id;

    private String username;

    private List<UserDTO> followers;

    private List<TweetDTO> tweets;

    public UserDTO() {
    }

    public UserDTO(String id, String username, List<UserDTO> followers, List<TweetDTO> tweets) {
        this.id = id;
        this.username = username;
        this.followers = followers;
        this.tweets = tweets;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public List<TweetDTO> getTweets() {
        return tweets;
    }

    public static UserDTOBuilder newBuilder()
    {
        return new UserDTOBuilder();
    }

    public static class UserDTOBuilder{
        private String id;
        private String username;
        private List<UserDTO> followers;
        private List<TweetDTO> tweets;

        public UserDTOBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        //TODO: run through lists
        public UserDTOBuilder setFollowers(List<UserDTO> followers) {
            this.followers = followers;
            return this;
        }

        public UserDTOBuilder setTweets(List<TweetDTO> tweets) {
            this.tweets = tweets;
            return this;
        }

        public UserDTO createUserDTO()
        {
            return new UserDTO(id, username, followers, tweets);
        }

    }
}
