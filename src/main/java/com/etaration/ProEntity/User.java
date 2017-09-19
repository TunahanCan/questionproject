package com.etaration.ProEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tunahan on 10.07.2017.
 */

@Entity
@Table(name = "UserTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID")
    private long id;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User()
    {

    }

    @Column(name = "UserName")
    private String username;

    @Column(name = "UserMail")
    private String email;

    @Column(name = "UserPassword")
    private String password;



    @OneToMany(mappedBy = "userComment", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<Comment>();


    @OneToMany(mappedBy = "userQuestion", cascade = CascadeType.ALL)
    private List<Question> questionList = new ArrayList<Question>();




    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
