package org.sprouts.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sprouts.backend.da.NoteDAO;
import org.sprouts.backend.security.UserDetailsService;
import org.sprouts.model.Authority;
import org.sprouts.model.Note;
import org.sprouts.model.UserAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Service
public class NoteService {

    // Managed Data Access Objects --------------------------------------------

    @Autowired
    private NoteDAO noteDAO;

    // Supporting Services ----------------------------------------------------

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
        Assert.isTrue(getCurrentPrincipal().equals(note.getUserAccount()), "The user that is assigned to the note is not the current principal");
        Date now = new Date(System.currentTimeMillis() - 1000);

        note.setPublishingDate(now);
        noteDAO.save(note);

        return 1;
    }

    // Auxiliary methods ------------------------------------------------------

    private UserAccount getCurrentPrincipal() {
        return (UserAccount) UserDetailsService.getPrincipal();
    }
}