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
public class Note extends DomainEntity {

    // Attributes -------------------------------------------------------------

    private String text;
    private Date publishingDate;
    private boolean isPublic;

    // Constructors -----------------------------------------------------------

    public Note() {
        super();
    }

    // Getters/Setters --------------------------------------------------------

    @NotBlank
    @NotNull
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @NotNull
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm")
    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    // Relationships ----------------------------------------------------------

    private UserAccount userAccount;

    @NotNull
    @Valid
    @ManyToOne(optional = false)
    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
