package controller.mapper;

import DTO.TweetDTO;
import DTO.UserDTO;
import domainobject.User;
import main.java.domainobject.Tweet;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User makeUser(UserDTO userDTO)
    {
        return new User(userDTO.getUsername());
    }


    public static UserDTO makeUserDTO(User user)
    {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername());


                //TODO: recursivo?
        List<User> followers = user.getFollowers();
        if (followers != null && !followers.isEmpty()){
            List<UserDTO> followersDTO = UserMapper.makeUsersDTOList(followers);
            userDTOBuilder.setFollowers(followersDTO);
        }

        List<Tweet> tweets = user.getTweets();
        if (tweets != null && !tweets.isEmpty()){
            List<TweetDTO> tweetsDTO = TweetMapper.makeTweetsDTOList(tweets);
            userDTOBuilder.setTweets(tweetsDTO);
        }


        return userDTOBuilder.createUserDTO();
    }


    public static List<UserDTO> makeUsersDTOList(Collection<User> users)
    {
        return users.stream()
                .map(UserMapper::makeUserDTO)
                .collect(Collectors.toList());
    }
}
