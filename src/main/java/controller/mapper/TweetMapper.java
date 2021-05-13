package controller.mapper;

import DTO.TweetDTO;
import DTO.UserDTO;
import domainobject.User;
import main.java.domainobject.Tweet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TweetMapper {

    public static Tweet makeTweet(TweetDTO tweetDTO)
    {
        return new Tweet(UserMapper.makeUser(tweetDTO.getUser()), tweetDTO.getText(), tweetDTO.getLocation());
    }


    public static TweetDTO makeTweetDTO(Tweet tweet)
    {
        TweetDTO.TweetDTOBuilder tweetDTOBuilder = TweetDTO.newBuilder()
            .setId(tweet.getId())
                .setText(tweet.getText())
                .setLocation(tweet.getLocation());

        User user = tweet.getUser();
        if (user != null)
        {
            UserDTO userDTO = UserMapper.makeUserDTO(user);
            tweetDTOBuilder.setUser(userDTO);
        }

        List<User> validators = tweet.getTweetValidators();
        if (validators!= null && !validators.isEmpty()){
            List<UserDTO> validatorsDTO = UserMapper.makeUsersDTOList(validators);
            tweetDTOBuilder.setTweetValidators(validatorsDTO);
        }

        return tweetDTOBuilder.createTweetDTO();
    }


    public static List<TweetDTO> makeTweetsDTOList(Collection<Tweet> tweets)
    {
        return tweets.stream()
                .map(TweetMapper::makeTweetDTO)
                .collect(Collectors.toList());
    }
}
