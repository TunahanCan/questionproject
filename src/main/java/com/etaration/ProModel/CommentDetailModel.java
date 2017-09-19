package com.etaration.ProModel;

import java.util.Date;

/**
 * Created by tunahan on 12.07.2017.
 */
public class CommentDetailModel extends BaseModel {

    private long id;
    private String Cevap;
    private String CommentName;
    private Date date;
    private String username;
    private long questionid;

    public CommentDetailModel(int errorCode, String errorMessage, long id, String cevap, String commentName, Date date, String username, long questionid) {
        super(errorCode, errorMessage);
        this.id = id;
        Cevap = cevap;
        CommentName = commentName;
        this.date = date;
        this.username = username;
        this.questionid = questionid;
    }

    public CommentDetailModel(long id, String cevap, String commentName, Date date, String username, long questionid) {
        this.id = id;
        Cevap = cevap;
        CommentName = commentName;
        this.date = date;
        this.username = username;
        this.questionid = questionid;
    }

    public CommentDetailModel() {
        super();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCevap() {
        return Cevap;
    }

    public void setCevap(String cevap) {
        Cevap = cevap;
    }

    public String getCommentName() {
        return CommentName;
    }

    public void setCommentName(String commentName) {
        CommentName = commentName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(long questionid) {
        this.questionid = questionid;
    }
}
