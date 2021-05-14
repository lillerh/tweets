package service;
import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repositories.TweetRepository;
import main.java.domainvalue.Language;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//@Service
@Component
public class TweetService {

    private TweetRepository tweetRepository;
    private Long minFollowersNum;
    private List<Language> allowedLanguages;
    private Integer topHashtagsN;

    @Autowired
    public TweetService(final TweetRepository tweetRepository, Long minFollowersNum, List<Language> allowedLanguages, Integer topHashtagsN)
    {
        this.tweetRepository = tweetRepository;
        this.minFollowersNum = minFollowersNum;
        this.allowedLanguages = allowedLanguages;
        this.topHashtagsN = topHashtagsN;
    }

    /**
     * Returns feed of tweets for a given user
     * @param userId logged user id
     * @throws IllegalArgumentException if invalid userId
     */
    public List<Tweet> getTweets(String userId){
        if(userId == null) throw new IllegalArgumentException("userId cannot be null");
        return tweetRepository.fetchTweetsForUser(userId);
    }

    /**
     * Validates the tweet
     * @param tweetId
     * @throws EntityNotFoundException
     */
    public void validateTweet(String tweetId, String userId){
        tweetRepository.validateTweet(tweetId, userId);
    }

    /**
     * Returns the validated tweets for a given user
     * @param userId
     * @throws EntityNotFoundException
     */
    public List<Tweet> getValidatedTweetsByUser(String userId){
        return tweetRepository.getValidatedTweetsByUser(userId);
    }

    /**
     * Returns n most used hashtags (by default 10)
     * @throws EntityNotFoundException
     */
    public List<String> getTopNHashtags(){
        return tweetRepository.getTopNHashtags()
                .stream()
                .map(hashtag -> hashtag.getTag())
                .collect(Collectors.toList());
    }


    /**
     * Creates tweet
     * TODO: http://twitter4j.org/en/ (Utilizar streaming API)
     * @param tweet
     */
    public Boolean createTweet(Tweet tweet){
        return tweetRepository.createTweet(tweet, minFollowersNum, allowedLanguages);
    }
}
