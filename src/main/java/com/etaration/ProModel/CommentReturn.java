package com.etaration.ProModel;


import java.util.List;

public class CommentReturn extends BaseModel {
    private List<CommentDetailModel> commenDetailModels;

    public List<CommentDetailModel> getCommenDetailModels() {
        return commenDetailModels;
    }

    public void setCommenDetailModels(List<CommentDetailModel> commenDetailModels) {
        this.commenDetailModels = commenDetailModels;
    }
}
