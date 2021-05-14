package DAO;
import main.java.domainobject.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetDAO extends CrudRepository<Tweet, Long> {


    List<Tweet> fetchTweetsForUser(String userId);

    void validateTweet(String tweetId, String userId);

    List<Tweet> getValidatedTweetsByUser(String userId);

}
