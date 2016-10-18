package com.rabobank.davidpardo.myassignement.model;

import java.util.Date;

/**
 * Created by davidpardo on 10/17/16.
 */

public class Issue {
    public String firstName;
    public String surname;
    public String issueCount;
    public String dateOfBirth;

    public Issue(String firstName, String surname, String issueCount, String dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.issueCount = issueCount;
        this.dateOfBirth = dateOfBirth;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String name) {
        this.firstName = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(String issueCount) {
        this.issueCount = issueCount;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
