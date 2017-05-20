package org.sprouts.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;


@Entity
@Access(AccessType.PROPERTY)
@Table
public class User extends DomainEntity {

    // Attributes -------------------------------------------------------------

    private String name;

    // Constructors -----------------------------------------------------------

    public User() {
        super();
    }

    // Getters/Setters --------------------------------------------------------

    @NotNull
    @NotBlank
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Relationships ----------------------------------------------------------

    private UserAccount userAccount;

    @NotNull
    @Valid
    @OneToOne(optional = false)
    @JoinColumn(name = "userAccountId")
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
