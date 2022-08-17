package com.speakr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Represents a user of the Speakr! social media app.
 * @author Alaciel de la Garza
 * @author Alonso del Arte
 * @author Lexi Henson
 */
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(unique = true)
    private String userName;

    @Column
    private String displayName;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Column
    private String bio;

    @Column
    private String role;

    @Column
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public boolean sameIdAs(User other) {
        return this.userId == other.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.userId
                + ", userName='" + this.userName + '\''
                + ", displayName='" + this.displayName + '\''
                + ", joinDate=" + this.joinDate
                + ", bio='" + this.bio + '\''
                + ", role='" + this.role + '\''
                + ", password=REDACTED}";
    }

    public User() { }

    public User(String name, String displayName, String bio) {
        this(name, displayName, bio, "PASSWORD WITHHELD");
    }

    public User(String name, String displayName, String bio, String password) {
        this.userName = name;
        this.displayName = displayName;
        this.bio = bio;
        this.password = password;
        this.joinDate = new Date();
    }

}
