package org.sprouts.backend.da;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.sprouts.model.Note;
import org.sprouts.model.User;

import java.util.Collection;

public interface UserDAO extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.userAccount.username=?1")
    User findByUsername(String username);
}
