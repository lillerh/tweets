package DAO;

import domainobject.User;
import org.springframework.data.repository.CrudRepository;
import main.java.domainobject.Tweet;

public interface UserDAO extends CrudRepository<Tweet, Long> {

    User getUser(String userId);
}
