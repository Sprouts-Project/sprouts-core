package org.sprouts.backend.service;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sprouts.backend.da.NoteDAO;
import org.sprouts.backend.security.UserDetailsService;
import org.sprouts.model.Note;
import org.sprouts.model.UserAccount;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;


@Service
@Transactional
public class NoteService {

    // Managed Data Access Objects --------------------------------------------

    @Autowired
    private NoteDAO noteDAO;

    // Supporting Services ----------------------------------------------------

    @Autowired
    private UserAccountService userAccountService;

    // Simple CRUD Methods ----------------------------------------------------

    public Collection<Note> findByPrincipal() {
        UserAccount principal = getCurrentPrincipal();
        Assert.notNull(principal, "You must be logged in to perform this operation");
        return noteDAO.findByUserAccount(principal);
    }

    public Collection<Note> findAllPublic() {
        return noteDAO.findAllPublic();
    }

    public int save(Note note) {
        Assert.notNull(getCurrentPrincipal(), "You must be logged in to perform this operation");
        Date now = new Date(System.currentTimeMillis() - 1000);

        note.setPublishingDate(now);
        note.setUserAccount(getCurrentPrincipal());
        noteDAO.save(note);

        return 1;
    }

    // Auxiliary methods ------------------------------------------------------

    private UserAccount getCurrentPrincipal() {
        return userAccountService.findByPrincipal();
    }
}