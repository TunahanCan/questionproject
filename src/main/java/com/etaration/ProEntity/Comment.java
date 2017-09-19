package com.etaration.ProEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tunahan on 10.07.2017.
 */
@Entity
@Table(name = "CommentTable")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CommentID")
    private long id;

    @Column(name = "cevap")
    private String Cevap;

    @Column(name = "commentName")
    private String CommentName;

    @Column(name = "tarih")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "UserID")
    private User userComment;



    @ManyToOne
    @JoinColumn(name = "QuestionID")
    private Question sorununcevaplari;


    public Comment(String cevap, String commentName, Date date, User userComment, Question sorununcevaplari) {
        Cevap = cevap;
        CommentName = commentName;
        this.date = date;
        this.userComment = userComment;
        this.sorununcevaplari = sorununcevaplari;
    }

    public Comment(){}

    public long getId() {
        return id;
    }



    public User getUserComment() {
        return userComment;
    }

    public void setUserComment(User userComment) {
        this.userComment = userComment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCevap() {
        return Cevap;
    }

    public void setCevap(String cevap) {
        this.Cevap = cevap;
    }

    public String getCommentName() {
        return CommentName;
    }

    public void setCommentName(String commentName) {
        this.CommentName = commentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Question getSorununcevaplari() {
        return sorununcevaplari;
    }

    public void setSorununcevaplari(Question sorununcevaplari) {
        this.sorununcevaplari = sorununcevaplari;
    }
}
