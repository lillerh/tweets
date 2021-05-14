package DAO.impl;

import DAO.HashtagDAO;
import domainobject.Hashtag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class InMemoryHashtagDAOImpl implements HashtagDAO {


    //In memory data structures
    private HashMap<Hashtag, Long> hashtagsFreq;

    private List<Hashtag> topHashtags;

    // frequency of last hashtag in topNHashtags cache
    private Long minFreqInHashtagsCache;

    private Integer topHashtagsN;

    public InMemoryHashtagDAOImpl(){
        hashtagsFreq = new HashMap<>();
        topHashtags = new ArrayList<>();
        topHashtagsN = 10; //TODO: Pending to be received in constructor autowired
    }


    public List<Hashtag> getTopNHashtags(){

        return topHashtags.subList(0, Math.min(topHashtags.size(),topHashtagsN));
    }


    /**
     * This method is called by the stream of tweets as they arrive
     * @param hashtags
     */
    @Override
    public void updateHashtagsFreq(List<Hashtag> hashtags){
        hashtags.forEach(h -> {
            Long hashFreq = hashtagsFreq.getOrDefault(h, 0L) + 1;
            hashtagsFreq.put(h, hashFreq);
            updateTopNHashtagsCache(h,hashFreq);
        });
    }

    /**
     * This method will be called by our batch processor that regularly updates the cache of topNHashtags
     * @param mostRecentTopNHashtags
     */
    @Override
    public void refreshCachedHashtagsFreq(List<Hashtag> mostRecentTopNHashtags){
        if (mostRecentTopNHashtags == null || hashtagsFreq.size()==0)
            return;

        topHashtags = mostRecentTopNHashtags;
        minFreqInHashtagsCache = hashtagsFreq.getOrDefault(topHashtags.get(topHashtags.size()-1), 0L);
    }

    private void updateTopNHashtagsCache(Hashtag hashtag, Long hashtagFreq){
        if(hashtagFreq <= minFreqInHashtagsCache)
            return;

        minFreqInHashtagsCache = hashtagFreq;
       // get index of element with less freq to insert new hashtag more frequent
       int indexToInsertHashtag = topHashtags.indexOf(topHashtags.stream()
                                                        .filter(h -> hashtagsFreq.get(h)<minFreqInHashtagsCache)
                                                        .findFirst()
       );
       topHashtags.add(indexToInsertHashtag, hashtag);
       // remove last element of the list
       topHashtags.remove(topHashtags.size()-1);

    }

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
