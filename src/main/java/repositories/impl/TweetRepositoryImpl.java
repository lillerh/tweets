package repositories.impl;

import DAO.HashtagDAO;
import DAO.TweetDAO;
import DAO.UserDAO;
import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import main.java.domainvalue.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.TweetRepository;

import java.util.List;

@Component
public class TweetRepositoryImpl implements TweetRepository {

    private TweetDAO tweetDAO;
    private HashtagDAO hashtagDAO;
    private UserDAO userDAO;


    @Autowired
    public TweetRepositoryImpl(final TweetDAO tweetDAO, final HashtagDAO hashtagDAO, final UserDAO userDAO)
    {
        this.tweetDAO = tweetDAO;
        this.hashtagDAO = hashtagDAO;
        this.userDAO = userDAO;
    }


    @Override
    public List<Tweet> fetchTweetsForUser(String userId) {
        return tweetDAO.fetchTweetsForUser(userId);

    }

    @Override
    public void validateTweet(String tweetId, String userId) {
        if (userDAO.getUser(userId) == null)
            return;
        tweetDAO.validateTweet(tweetId, userId);

    }

    @Override
    public List<Tweet> getValidatedTweetsByUser(String userId) {
        return tweetDAO.getValidatedTweetsByUser(userId);
    }

    @Override
    public List<Hashtag> getTopNHashtags() {

        return hashtagDAO.getTopNHashtags();
    }

    @Override
    public Boolean createTweet(Tweet tweet, Long minFollowersNum, List<Language> allowedLanguages) {
        User user = userDAO.getUser(tweet.getUserId());
        if(user.getFollowers().size() > minFollowersNum && allowedLanguages.contains(tweet.getLanguage())){
            tweetDAO.save(tweet);
            hashtagDAO.updateHashtagsFreq(tweet.getHashtags());
            return true;
        }

        return false;
    }
}
