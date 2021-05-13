package DAO.impl;

import DAO.HashtagDAO;
import domainobject.Hashtag;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HashtagDAOImpl implements HashtagDAO {


    HashMap<Hashtag, Integer> topHashtags;




    //Extended from CRUD - not implemented for now
    @Override
    public <S extends Hashtag> S save(S s) {
        return null;
    }

    @Override
    public <S extends Hashtag> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Hashtag> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Hashtag> findAll() {
        return null;
    }

    @Override
    public Iterable<Hashtag> findAllById(Iterable<Long> iterable) {
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
    public void delete(Hashtag hashtag) {

    }

    @Override
    public void deleteAll(Iterable<? extends Hashtag> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
