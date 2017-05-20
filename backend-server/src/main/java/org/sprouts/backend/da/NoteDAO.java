package org.sprouts.backend.da;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.sprouts.model.Note;
import org.sprouts.model.User;
import org.sprouts.model.UserAccount;

import java.util.Collection;

public interface NoteDAO extends CrudRepository<Note, Integer> {

    Collection<Note> findByUser(User user);

    @Query("select n from Note n where n.public = true")
    Collection<Note> findAllPublic();
}
