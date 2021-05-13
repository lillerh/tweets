package DAO.impl;

import DAO.HashtagDAO;
import domainobject.Hashtag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class HashtagDAOImpl implements HashtagDAO {


    private HashMap<Hashtag, Integer> hashtagsFreq;

    private List<Hashtag> topHashtags;

    public HashtagDAOImpl(){
        hashtagsFreq = new HashMap<>();
        topHashtags = new ArrayList<>();
    }


    public List<Hashtag> getTopKHashtags(Integer k){
        return topHashtags.subList(0, Math.min(topHashtags.size(),k));
    }


    @Override
    public <S extends Hashtag> S save(S s) {
        hashtagsFreq.put(s, hashtagsFreq.getOrDefault(s, 0) + 1);

        // TODO: update sorted list of topHashtags as needed after inserting the new hashtag

        return s;
    }

    //Extended from CRUD - not implemented for now

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
