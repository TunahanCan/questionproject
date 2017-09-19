package com.etaration.ProModel;

import java.util.List;

/**
 * Created by tunahan on 13.07.2017.
 */
public class QuestionReturn extends BaseModel
{
    private List<QuestionDetailModel> questionDetailModels;

    public List<QuestionDetailModel> getQuestionDetailModels() {
        return questionDetailModels;
    }

    public void setQuestionDetailModels(List<QuestionDetailModel> questionDetailModels) {
        this.questionDetailModels = questionDetailModels;
    }
}
