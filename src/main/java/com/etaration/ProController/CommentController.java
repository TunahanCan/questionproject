package com.etaration.ProController;

import com.etaration.ProEntity.Comment;
import com.etaration.ProEntity.User;
import com.etaration.ProModel.BaseModel;
import com.etaration.ProModel.CommentDetailModel;
import com.etaration.ProModel.CommentReturn;
import com.etaration.ProServices.CommentServices;
import com.etaration.ProServices.QuestionServices;
import com.etaration.ProServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tunahan on 12.07.2017.
 */

@RestController
@RequestMapping(value = "/Comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    @Autowired
    QuestionServices questionServices;

    @Autowired
    UserServices userServices;

    @Autowired
    CommentServices commentServices;


    @RequestMapping(value = "/add")
    public BaseModel commentAdd(@RequestBody CommentDetailModel cmodel) {
        BaseModel baseModel = new BaseModel();
        try {

            Comment comment = new Comment();
            comment.setUserComment(userServices.KullaniciGetir(cmodel.getUsername()));
            comment.setSorununcevaplari(questionServices.SoruBUL(cmodel.getQuestionid()));
            comment.setCevap(cmodel.getCevap());
            comment.setDate(cmodel.getDate());
            comment.setCommentName(userServices.KullaniciGetir(cmodel.getUsername()).getUsername());
            commentServices.saveComment(comment);
            baseModel.setErrorCode(0);
            baseModel.setErrorMessage("cevap basari ile eklendi");

        } catch (Exception e) {
            e.printStackTrace();
            baseModel.setErrorCode(1);
            baseModel.setErrorMessage("cevap ekleme basarisiz");
        }

        return baseModel;

    }


    @RequestMapping(value = "/all/{username}")
    public CommentReturn CevapGetir(@PathVariable(value = "username") String username) {

        CommentReturn commentReturn = new CommentReturn();
        commentReturn.setCommenDetailModels(new ArrayList<>());
        User user = userServices.KullaniciGetir(username);

        try {
            List<Comment> liste = commentServices.KullanicininVerdigiCevaplar(user);

            for (Comment item : liste) {
                CommentDetailModel model = new CommentDetailModel();
                model.setCevap(item.getCevap());

                model.setId(item.getId());
                model.setDate(item.getDate());

                if (item.getUserComment() != null) {
                    model.setCommentName(item.getUserComment().getUsername());
                    model.setUsername(item.getUserComment().getUsername());
                }

                if (item.getSorununcevaplari() != null)
                    model.setQuestionid(item.getSorununcevaplari().getId());

                model.setErrorCode(0);
                model.setErrorMessage("Oldu");
                commentReturn.getCommenDetailModels().add(model);

            }

            commentReturn.setErrorCode(0);
            commentReturn.setErrorMessage("Listeleme Başarılı");


        } catch (Exception e) {
            e.printStackTrace();

            commentReturn.setErrorCode(1);
            commentReturn.setErrorMessage("Yalnışlık" + e.getClass().getName() + " " + e.getMessage());
        }

        return commentReturn;
    }

    @RequestMapping(value = "/all")
    public CommentReturn HepsiniGetir() {
        CommentReturn commentReturn = new CommentReturn();
        commentReturn.setCommenDetailModels(new ArrayList<>());
        List<Comment> listem = commentServices.CevaplariGetir();

        try {
            for (Comment item : listem) {
                CommentDetailModel model = new CommentDetailModel();
                model.setUsername(item.getUserComment().getUsername());
                model.setQuestionid(item.getSorununcevaplari().getId());
                model.setCommentName(item.getUserComment().getUsername());
                model.setDate(item.getDate());
                model.setCevap(item.getCevap());

                model.setErrorCode(0);
                model.setErrorMessage("olduu detail model");
                commentReturn.getCommenDetailModels().add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
            commentReturn.setErrorCode(1);
            commentReturn.setErrorMessage("hata veriler gelmedi");

        }
        return commentReturn;

    }


}
