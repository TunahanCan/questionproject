package com.etaration.ProRepository;

import com.etaration.ProEntity.Comment;
import com.etaration.ProEntity.Question;
import com.etaration.ProEntity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tunahan on 10.07.2017.
 */


public interface CommentRepository extends CrudRepository<Comment,Long> {


    public List<Comment> findByUserComment(User user);

    public List<Comment> findBySorununcevaplari(Question question);


    public List<Question> findBySorununcevaplari(Comment comment);




}
