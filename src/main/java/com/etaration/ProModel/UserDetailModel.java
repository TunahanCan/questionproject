package com.etaration.ProModel;

/**
 * Created by tunahan on 12.07.2017.
 */
public class UserDetailModel extends BaseModel {

    private String userId;
    private String username;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetailModel()
    {
        super();
    }

    public UserDetailModel(int errorCode, String errorMessage, String userId, String username, String password, String email) {
        super(errorCode, errorMessage);
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public UserDetailModel(String userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
