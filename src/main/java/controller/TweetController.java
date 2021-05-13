package main.java.controller;

import DTO.TweetDTO;
import controller.mapper.TweetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TweetService;

import main.java.domainobject.Tweet;


import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * All operations related with tweets will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/tweets")
public class TweetController {

    private TweetService tweetService;

    @Autowired
    public TweetController(final TweetService tweetService)
    {
        this.tweetService = tweetService;
    }


    @GetMapping("/{userId}")
    public List<TweetDTO> getTweets(@PathVariable String userId) throws EntityNotFoundException
    {
        List<Tweet> tweets = tweetService.getTweets(userId);
        return TweetMapper.makeTweetsDTOList(tweets);
    }

    @PutMapping("/{tweetId}")
    public void validateTweet(@PathVariable String tweetId,  @RequestParam String userId) throws EntityNotFoundException
    {
        tweetService.validateTweet(tweetId, userId);
    }

    @GetMapping("/{userId}")
    public List<TweetDTO> getValidatedTweetsByUser(@PathVariable String userId){
        List<Tweet> validatedTweets = tweetService.getValidatedTweetsByUser(userId);
        return TweetMapper.makeTweetsDTOList(validatedTweets);
    }

    @GetMapping
    public List<String> getTopKHashtags(@RequestParam Integer k){
        return tweetService.getTopKHashtags(k);
    }
}
