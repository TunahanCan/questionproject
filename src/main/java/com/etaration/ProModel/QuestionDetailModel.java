package com.etaration.ProModel;
import java.util.Date;

/**
 * Created by tunahan on 12.07.2017.
 */
public class QuestionDetailModel extends BaseModel {

    private long id;
    private String QuestionTag;
    private String Description;
    private String username;
    private long Avarage;
    private Date date;

    public QuestionDetailModel(int errorCode, String errorMessage, long id, String questionTag, String description, String username, long avarage, Date date) {
        super(errorCode, errorMessage);
        this.id = id;
        QuestionTag = questionTag;
        Description = description;
        this.username = username;
        Avarage = avarage;
        this.date = date;
    }

    public QuestionDetailModel(long id, String questionTag, String description, String username, long avarage, Date date) {
        this.id = id;
        QuestionTag = questionTag;
        Description = description;
        this.username = username;
        Avarage = avarage;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public QuestionDetailModel(){
        super();}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestionTag() {
        return QuestionTag;
    }

    public void setQuestionTag(String questionTag) {
        QuestionTag = questionTag;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getAvarage() {
        return Avarage;
    }

    public void setAvarage(long avarage) {
        Avarage = avarage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
