package DAO;

import domainobject.User;
import main.java.domainobject.Tweet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long> {

    List<Tweet> getValidatedTweetsByUser(String userId);
}
