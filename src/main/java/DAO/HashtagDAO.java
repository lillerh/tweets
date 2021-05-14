package DAO;


import domainobject.Hashtag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HashtagDAO extends CrudRepository<Hashtag, Long> {

     List<Hashtag> getTopNHashtags();

    void updateHashtagsFreq(List<Hashtag> hashtags);

    void refreshCachedHashtagsFreq(List<Hashtag> mostRecentTopNHashtags);

    }
