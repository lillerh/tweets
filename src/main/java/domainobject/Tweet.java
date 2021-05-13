package main.java.domainobject;


import domainobject.User;
import main.java.domainvalue.Language;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "tweet"
)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String location;

    @ManyToMany(mappedBy = "tweets")
    private List<User> tweetValidators;

    @Enumerated(EnumType.STRING)
    private Language language;

    public Tweet(User user, String text, String location, Language language){
        this.user = user;
        this.text = text;
        this.location = location;
        this.language = language;
    }

    public String getId()
    {
        return id;
    }


    public void setId(String id)
    {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<User> getTweetValidators() {
        return tweetValidators;
    }

    public void setTweetValidators(List<User> tweetValidators) {
        this.tweetValidators = tweetValidators;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Boolean isValidated(){
        return tweetValidators!=null && tweetValidators.size() > 0;
    }


}
