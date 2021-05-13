package repositories.impl;

import DAO.HashtagDAO;
import DAO.TweetDAO;
import DAO.UserDAO;
import domainobject.Hashtag;
import domainobject.User;
import main.java.domainobject.Tweet;
import main.java.domainvalue.Language;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.TweetRepository;

import java.util.List;

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
        return tweetDAO.fetchTweetsByUserId(userId);

    }

    @Override
    public void validateTweet(String tweetId, String userId) {
        tweetDAO.validateTweet(tweetId, userId);

    }

    @Override
    public List<Tweet> getValidatedTweetsByUser(String userId) {

        return userDAO.getValidatedTweetsByUser(userId);
    }

    @Override
    public List<Hashtag> getTopKHashtags(Integer k) {

        return hashtagDAO.getTopKHashtags(k);
    }

    @Override
    public Boolean createTweet(User user, Tweet tweet, Long minFollowersNum, List<Language> allowedLanguages) {
        if(user.getFollowers().size() > minFollowersNum && allowedLanguages.contains(tweet.getLanguage())){
            tweetDAO.save(tweet);
            return true;
        }

        return false;
    }
}
