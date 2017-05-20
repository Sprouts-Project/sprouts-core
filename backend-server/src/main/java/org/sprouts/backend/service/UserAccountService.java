package org.sprouts.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.sprouts.backend.da.UserAccountDAO;
import org.sprouts.backend.security.UserDetailsService;
import org.sprouts.model.Authority;
import org.sprouts.model.UserAccount;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserAccountService {

    // Managed Data Access Objects --------------------------------------------

    @Autowired
    private UserAccountDAO userAccountDAO;

    // Simple CRUD Methods ----------------------------------------------------

    // Auxiliary methods -----------------------------------------------------

    public UserAccount findByPrincipal() {
        UserDetails userDetails = UserDetailsService.getPrincipal();
        Assert.notNull(userDetails);

        return userAccountDAO.findByUsername(userDetails.getUsername());
    }
}