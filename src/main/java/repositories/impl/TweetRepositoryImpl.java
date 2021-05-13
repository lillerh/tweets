package repositories.impl;

import DAO.impl.HashtagDAOImpl;
import DAO.impl.TweetDAOImpl;
import DAO.impl.UserDAOImpl;
import domainobject.Hashtag;
import main.java.domainobject.Tweet;
import repositories.TweetRepository;

import java.util.List;

public class TweetRepositoryImpl implements TweetRepository {

    private TweetDAOImpl tweetDAOImpl;
    private HashtagDAOImpl hashtagDAOImpl;
    private UserDAOImpl userDAOImpl;

    @Override
    public List<Tweet> fetchTweetsForUser(String userId) {
        return tweetDAOImpl.fetchTweetsByUserId(userId);

    }

    @Override
    public void validateTweet(String tweetId, String userId) {
        tweetDAOImpl.validateTweet(tweetId, userId);

    }

    @Override
    public List<Tweet> getValidatedTweetsByUser(String userId) {

        return userDAOImpl.getValidatedTweetsByUser(userId);
    }

    @Override
    public List<Hashtag> fetchMoreUsedHashtags(Long count) {
        return null;
    }
}
