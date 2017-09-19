package com.etaration.ProServices;

import com.etaration.ProEntity.Comment;
import com.etaration.ProEntity.Question;
import com.etaration.ProEntity.User;
import com.etaration.ProRepository.CommentRepository;
import com.etaration.ProRepository.QuestionRepository;
import com.etaration.ProRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tunahan on 10.07.2017.
 */


@Service
public class CommentServices {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;



    public Comment createComment()
    {
        return new Comment();
    }

    public void saveComment(Comment comment)
    {
        commentRepository.save(comment);
    }


    public List<Comment> cevaplariGetir(Question question)
    {
        return commentRepository.findBySorununcevaplari(question);
    }


    public List<Comment> KullanicininVerdigiCevaplar(User user)
    {
          return commentRepository.findByUserComment(user);
    }


    public List<Comment> CevaplariGetir()
    {
        return (List<Comment>) commentRepository.findAll();

    }





}
