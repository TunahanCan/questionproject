package com.etaration.ProController;

import com.etaration.ProEntity.Question;
import com.etaration.ProEntity.User;
import com.etaration.ProModel.BaseModel;
import com.etaration.ProModel.QuestionDetailModel;
import com.etaration.ProModel.QuestionReturn;
import com.etaration.ProServices.CommentServices;
import com.etaration.ProServices.QuestionServices;
import com.etaration.ProServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tunahan on 11.07.2017.
 *
 * @RequestMapping(value = "/add", method = RequestMethod.POST)
 * public boolean addQuestion(@RequestBody Question question)
 * {
 * <p>
 * questionServices.SaveQuestion(question);
 * return true;
 * }
 * @RequestMapping(value = "/AllUserQuestion/{id}", method = RequestMethod.GET)
 * public List<Question> AllUserQuestion (@PathVariable("id") Long id)
 * {
 * User user = userServices.KullaniciGetir(id);
 * List<Question> sorular = questionServices.userSearch(user);
 * return sorular;
 * }
 * @RequestMapping(value = "/allQuestionComment/{id}", method = RequestMethod.GET)
 * public List<Comment> allQuestionComment(@PathVariable("id") Long id)
 * {
 * Question question = questionServices.getCommentByQuestion(id);
 * List<Comment> comments = commentServices.cevaplariGetir(question);
 * return comments;
 * }
 * @RequestMapping(value = "/Del/{id}", method = RequestMethod.DELETE)
 * public boolean DelQuestion(@PathVariable("id") Long id)
 * {
 * Question question = questionServices.getCommentByQuestion(id);
 * questionServices.delQuestion(question);
 * return true;
 * <p>
 * <p>
 * }
 * @RequestMapping(value = "/allquestion/{username}")
 * public List<Question> SorulariGetir(@PathVariable(value = "username") String username)
 * {
 * User user = userServices.KullaniciGetir(username);
 * List<Question> cevaplist = questionServices.userSearch(user);
 * return cevaplist;
 * }
 * @RequestMapping(value = "/alluser/{questionid}")
 * public List<User> KullanicilariGetir(@PathVariable(value = "questionid") Long questionid)
 * {
 * <p>
 * Question question = questionServices.SoruBUL(questionid);
 * List<User> liste = questionServices.CevaplayanlariBUl(question);
 * return liste;
 * }
 */
@RestController
@RequestMapping(value = "/Question")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class QuestionController {
    @Autowired
    QuestionServices questionServices;

    @Autowired
    UserServices userServices;

    @Autowired
    CommentServices commentServices;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public BaseModel QuestionAdd(@RequestBody QuestionDetailModel detailModel) {
        BaseModel baseModel = new BaseModel();
        try {
            Question question = new Question(); // Soru entitysi yaratildi;
            question.setQuestionTag(detailModel.getQuestionTag());
            question.setDescription(detailModel.getDescription());
            User user = userServices.KullaniciGetir(detailModel.getUsername()); //soruyu yaratan user enttysi cagrildi
            question.setUserQuestion(user);
            questionServices.SaveQuestion(question);
            baseModel.setErrorCode(0);
            baseModel.setErrorMessage("SİNEJDERR VURDU GOOOL OLDU");
        } catch (Exception e) {
            e.printStackTrace();
            baseModel.setErrorCode(1);
            baseModel.setErrorMessage("Yanlışlık " + e.getClass().getName() + " " + e.getMessage());
        }

        return baseModel;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public QuestionReturn QestionAllReturn() {
        QuestionReturn questionReturn = new QuestionReturn();
        questionReturn.setQuestionDetailModels(new ArrayList<>());
        List<Question> listem = questionServices.getAll();
        try {
            for (Question question : listem) {
                QuestionDetailModel model = new QuestionDetailModel();
                model.setId(question.getId());
                model.setAvarage(question.getAvarage());
                model.setDate(question.getDate());
                model.setDescription(question.getDescription());
                model.setQuestionTag(question.getQuestionTag());
                if (question.getUserQuestion() != null) {
                    model.setUsername(question.getUserQuestion().getUsername());
                }
                model.setErrorCode(0);
                model.setErrorMessage("olduu detail model");
                questionReturn.getQuestionDetailModels().add(model);
            }
            questionReturn.setErrorCode(0);
            questionReturn.setErrorMessage("oldu return model");

        } catch (Exception e) {
            e.printStackTrace();

            questionReturn.setErrorCode(1);
            questionReturn.setErrorMessage("Hata Var bi yerlerde " + e.getClass().getName() + " " + e.getMessage());
        }
       return questionReturn;
    }

    @RequestMapping(value = "/all/{username}", method = RequestMethod.GET)
    public QuestionReturn SorulariGetir(@PathVariable(value = "username") String username) {
        QuestionReturn questionReturn = new QuestionReturn();
        questionReturn.setQuestionDetailModels(new ArrayList<>());

        try {
            User user = userServices.KullaniciGetir(username);
            List<Question> cevaplist = questionServices.userSearch(user);
            for (Question question : cevaplist) {
                QuestionDetailModel model = new QuestionDetailModel();
                model.setId(question.getId());
                model.setAvarage(question.getAvarage());
                model.setDate(question.getDate());
                model.setDescription(question.getDescription());
                model.setQuestionTag(question.getQuestionTag());
                if (question.getUserQuestion() != null) {
                    model.setUsername(question.getUserQuestion().getUsername());
                }
                model.setErrorCode(0);
                model.setErrorMessage("olduu detail model");
                questionReturn.getQuestionDetailModels().add(model);
            }

            questionReturn.setErrorCode(0);
            questionReturn.setErrorMessage("oldu return model");

        } catch (Exception e) {
            e.printStackTrace();

            questionReturn.setErrorCode(1);
            questionReturn.setErrorMessage("Hata Var bi yerlerde " + e.getClass().getName() + " " + e.getMessage());
        }
        return questionReturn;
    }


}
