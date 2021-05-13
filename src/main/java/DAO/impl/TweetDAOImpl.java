package DAO.impl;

import DAO.TweetDAO;
import domainobject.User;
import main.java.domainobject.Tweet;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TweetDAOImpl implements TweetDAO {
    private EntityManager manager;

    public TweetDAOImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Tweet> fetchTweetsByUserId(String userId) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        //TODO: fetch the tweets
        return tweets;
    }

    @Override
    public void validateTweet(String tweetId, String userId) {
        //TODO: control exceptions
        Tweet tweet = manager.find(Tweet.class, tweetId);
        List<User> validators = tweet.getTweetValidators();
        User newValidator = manager.find(User.class, userId);
        validators.add(newValidator);
    }

    //Extended from CRUD - not implemented for now
    @Override
    public <S extends Tweet> S save(S s) {
        return null;
    }

    @Override
    public <S extends Tweet> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Tweet> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Tweet> findAll() {
        return null;
    }

    @Override
    public Iterable<Tweet> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Tweet tweet) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tweet> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
