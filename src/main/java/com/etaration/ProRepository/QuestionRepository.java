package com.etaration.ProRepository;
import com.etaration.ProEntity.Question;
import com.etaration.ProEntity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by tunahan on 10.07.2017.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {

   public Question findById(long id);

   public List<Question> findByUserQuestion(User user);

   public List<User> findAllByUserQuestionId(long id);

   public User findByUserQuestionId(long id);





}
