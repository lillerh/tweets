package DAO.impl;

import DAO.UserDAO;
import domainobject.User;
import main.java.domainobject.Tweet;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private EntityManager manager;

    public UserDAOImpl(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public List<Tweet> getValidatedTweetsByUser(String userId) {
        //TODO: control exceptions
        User user = manager.find(User.class, userId);
        return user.getValidatedTweets();
    }

    //Extended from CRUD - not implemented for now
    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
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
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
