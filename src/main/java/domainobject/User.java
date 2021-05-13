package domainobject;

import main.java.domainobject.Tweet;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "user"
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String username;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_follower",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> followers;

    @OneToMany(mappedBy = "tweet")
    private List<Tweet> tweets;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_tweetsValidator",
            joinColumns = @JoinColumn(name = "tweet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Tweet> validatedTweets;

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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public List<Tweet> getValidatedTweets() {
        return validatedTweets;
    }

    public void setValidatedTweets(List<Tweet> validatedTweets) {
        this.validatedTweets = validatedTweets;
    }
}
