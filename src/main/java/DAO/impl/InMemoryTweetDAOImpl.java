package DAO.impl;

import DAO.TweetDAO;
import main.java.domainobject.Tweet;

import java.util.*;

public class InMemoryTweetDAOImpl implements TweetDAO {

    //In memory data structures
    private HashMap<String, Tweet> tweetsDB; //all the tweets <tweetId, Tweet>

    private HashMap<String, Stack<Tweet>> tweetsFeedForUser; //cached feed the tweets for user

    private HashMap<String, List<Tweet>> tweetsValidatedByUser;


    public InMemoryTweetDAOImpl(){
        tweetsDB = new HashMap<>();
        tweetsFeedForUser = new HashMap<>();
        tweetsValidatedByUser = new HashMap<>();
    }


    @Override
    public List<Tweet> fetchTweetsForUser(String userId) {
        List<Tweet> result = new ArrayList<>(tweetsFeedForUser.getOrDefault(userId, new Stack<>()));
        Collections.reverse(result);
        return result;
    }

    @Override
    public void validateTweet(String tweetId, String userId) {
        final Tweet tweet = tweetsDB.getOrDefault(tweetId, null);

        if (tweet == null) return; //TODO: Throw TweetNotFoundException

        if (!tweetsValidatedByUser.containsKey(userId))
            tweetsValidatedByUser.put(userId, new ArrayList<>());

        tweetsValidatedByUser.get(userId).add(tweet);

    }

    @Override
    public List<Tweet> getValidatedTweetsByUser(String userId) {
        return tweetsValidatedByUser.getOrDefault(userId, new ArrayList<>());
    }



    @Override
    public <S extends Tweet> S save(S s) {

        tweetsDB.put(s.getUserId(), s);

        return s;
    }


    /**
     * This method will be called when there are new tweets for user in the tweets stream
     * @param userId
     * @param tweets - more recent tweets from user contacts
     * */
    public void addTweetsForUser(String userId, List<Tweet> tweets){

        if (!tweetsFeedForUser.containsKey(userId))
            tweetsFeedForUser.put(userId, new Stack());

        tweetsFeedForUser.get(userId).addAll(tweets);
    }

    //Extended from CRUD - not implemented for now


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
