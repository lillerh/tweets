package repositories;

import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import main.java.domainvalue.Language;

import java.util.List;

//@Repository
@Component
public interface TweetRepository {

    List<Tweet> fetchTweetsForUser(String userId);

    void validateTweet(String tweetId, String userId);

    List<Tweet> getValidatedTweetsByUser(String userId);

    List<Hashtag> getTopNHashtags();

    Boolean createTweet(Tweet tweet, Long minFollowersNum, List<Language> allowedLanguages);

}
