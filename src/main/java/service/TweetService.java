package service;
import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TweetRepository;
import main.java.domainvalue.Language;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class TweetService {

    private TweetRepository tweetRepository;
    private Long minFollowersNum;
    private List<Language> allowedLanguages;

    @Autowired
    public TweetService(final TweetRepository tweetRepository, Long minFollowersNum, List<Language> allowedLanguages)
    {
        this.tweetRepository = tweetRepository;
        this.minFollowersNum = minFollowersNum;
        this.allowedLanguages = allowedLanguages;
    }

    /**
     * Returns feed of tweets for a given user
     * @param userId
     * @throws EntityNotFoundException
     */
    public List<Tweet> getTweets(String userId){
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
     * Returns n most used hashtags
     * @param k
     * @throws EntityNotFoundException
     */
    public List<String> getTopKHashtags(Integer k){
        return tweetRepository.getTopKHashtags(k)
                .stream()
                .map(hashtag -> hashtag.getTag())
                .collect(Collectors.toList());
    }


    /**
     * Creates tweet
     * TODO: http://twitter4j.org/en/ (Utilizar streaming API)
     * @param user
     * @param tweet
     */
    public Boolean createTweet(User user, Tweet tweet){
        return tweetRepository.createTweet(user, tweet, minFollowersNum, allowedLanguages);
    }
}
