package com.etaration.ProServices;

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
public class QuestionServices {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;


    public void SaveQuestion(Question question)
    {
        questionRepository.save(question);
    }

    public List<Question> getAll()
    {
        return (List<Question>) questionRepository.findAll();
    }

    public Question SoruBUL(long id)
    {
        return questionRepository.findById(id);
    }



    public List<User> CevaplayanlariBUl(Question question)
    {
        return questionRepository.findAllByUserQuestionId(question.getId());
    }

    public User OlusturaniBUl(User user)
    {
        return  questionRepository.findByUserQuestionId(user.getId());
    }



    public List<Question> userSearch(User user)
    {
        return questionRepository.findByUserQuestion(user);
    }

    public Question getCommentByQuestion(long id)
    {
        return questionRepository.findById(id);
    }

    public void delQuestion(Question question)
    {
        questionRepository.delete( questionRepository.findById(question.getId()));
    }


}
