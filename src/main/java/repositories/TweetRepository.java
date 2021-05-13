package repositories;

import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository {

    List<Tweet> fetchTweetsForUser(String userId);

    void validateTweet(String tweetId, String userId);

    List<Tweet> getValidatedTweetsByUser(String userId);

    List<Hashtag> fetchMoreUsedHashtags(Long count);

}
