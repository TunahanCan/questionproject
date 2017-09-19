package com.etaration.ProRepository;

import com.etaration.ProEntity.Comment;
import com.etaration.ProEntity.Question;
import com.etaration.ProEntity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by tunahan on 10.07.2017.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

      public User findById(long id);
      public User findByUsername(String name);
      public List<Comment> findByCommentList(User user);
      public List<Question> findByQuestionList(User user);

}
