package service;
import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import repositories.TweetRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class TweetService {

    private TweetRepository tweetRepository;

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
     * @param numberOfHashtagsToReturn
     * @throws EntityNotFoundException
     */
    public List<String> getMostUsedHashtags(Integer numberOfHashtagsToReturn){
return null;
    }


    /**
     * Creates tweet
     * @param user
     * @param tweet
     */
    public void createTweet(User user, Tweet tweet, Long followersNumber, String language){
        //usuario, texto, localización, validación.

        //if (followersNumber > 0)
       // if (user.getFollowers().size())
    }
}
