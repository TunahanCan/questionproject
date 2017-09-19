package com.etaration.ProEntity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tunahan on 10.07.2017.
 */

@Entity
@Table(name = "QuestionTable")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "QuestionID")
    private long id;

    @Column(name = "questionTag")
    private String QuestionTag;

    @Column(name = "questionDesc")
    private String Description;

    @Column(name = "quesAvarage")
    private long Avarage;

    @Column(name = "quesDate")
    private Date date;


    @ManyToOne
    @JoinColumn(name = "UserID")
    private User userQuestion;

    @OneToMany(mappedBy = "sorununcevaplari", cascade = CascadeType.ALL)
    private List<Comment> cevaplarigetir = new ArrayList<Comment>();



    public Question(long id, String questionTag, String description, long avarage, Date date) {
        this.id = id;
        QuestionTag = questionTag;
        Description = description;
        Avarage = avarage;
        this.date = date;
    }


    public Question() {}

    public Question(String questionTag, String description, long avarage, Date date, User userQuestion, List<Comment> cevaplarigetir) {
        QuestionTag = questionTag;
        Description = description;
        Avarage = avarage;
        this.date = date;
        this.userQuestion = userQuestion;
        this.cevaplarigetir = cevaplarigetir;
    }


    public User getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(User userQuestion) {
        this.userQuestion = userQuestion;
    }

    public List<Comment> getCevaplarigetir() {
        return cevaplarigetir;
    }

    public void setCevaplarigetir(List<Comment> cevaplarigetir) {
        this.cevaplarigetir = cevaplarigetir;
    }

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
