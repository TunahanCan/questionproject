package com.etaration.ProModel;

/**
 * Created by tunahan on 12.07.2017.
 */
public class BaseModel {

    private int errorCode;
    private String errorMessage;


    public BaseModel(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseModel() {

    }


    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
