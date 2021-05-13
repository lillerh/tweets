package repositories;

import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.stereotype.Repository;

import main.java.domainvalue.Language;

import java.util.List;

@Repository
public interface TweetRepository {

    List<Tweet> fetchTweetsForUser(String userId);

    void validateTweet(String tweetId, String userId);

    List<Tweet> getValidatedTweetsByUser(String userId);

    List<Hashtag> getTopKHashtags(Integer k);

    Boolean createTweet(User user, Tweet tweet, Long minFollowersNum, List<Language> allowedLanguages);

}
