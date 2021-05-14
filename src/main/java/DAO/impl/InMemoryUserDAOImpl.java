package DAO.impl;

import DAO.UserDAO;
import domainobject.User;
import main.java.domainobject.Tweet;

import java.util.HashMap;
import java.util.Optional;

public class InMemoryUserDAOImpl implements UserDAO {

    //In memory data structures
    private HashMap<String, User> usersDB; //all the users mapped by <userId, User>


    public InMemoryUserDAOImpl(){
        usersDB = new HashMap<>();
    }

    @Override
    public User getUser(String userId) {
        return usersDB.get(userId);
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
