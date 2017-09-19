package com.etaration.ProController;

import com.etaration.ProEntity.User;
import com.etaration.ProModel.BaseModel;
import com.etaration.ProModel.UserDetailModel;
import com.etaration.ProServices.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tunahan on 11.07.2017.
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserServices userServices;


    @RequestMapping(path = "/User/all", method = RequestMethod.GET)
    public List<User> UserAll() {
        return userServices.AllUser();
    }


    @RequestMapping(value = "/User/add", method = RequestMethod.PUT)
    public BaseModel addUser(@RequestBody UserDetailModel userDetailModel) {

        BaseModel baseModel = new BaseModel();
        try {
            User user = userServices.KullaniciGetir(userDetailModel.getUsername());
            if (user == null) {
                user = new User();

                user.setPassword(userDetailModel.getPassword());
                user.setEmail(userDetailModel.getEmail());
                user.setUsername(userDetailModel.getUsername());

                userServices.KullaniciOlustur(user);
                baseModel.setErrorCode(0);
                baseModel.setErrorMessage("Kullanıcı başarılı bir şekilde eklendi.");
            } else {

                baseModel.setErrorCode(1);
                baseModel.setErrorMessage("Hatalı giriş yaptınız");
            }

        } catch (Exception e) {
            e.printStackTrace();
            baseModel.setErrorCode(1);
            baseModel.setErrorMessage("Kullanıcı ekleme başarısız sebebi ->" + e.getClass().getName() + " " + e.getMessage());
        }
        return baseModel;
    }

    @RequestMapping(value = "/User/login", method = RequestMethod.POST)
    public BaseModel Userlogin(@RequestBody UserDetailModel userDetailModel) {
        BaseModel baseModel = new BaseModel();
        try {

            User user = userServices.KullaniciGetir(userDetailModel.getUsername()); //userService.findUserByUserName(userDetailModel.getUserName());
            if (user != null && user.getPassword().equals(userDetailModel.getPassword())) {

                baseModel.setErrorCode(0);
                baseModel.setErrorMessage("BackEnd diyorki -> Kullanıcı girişi başarılı.");

            } else {
                baseModel.setErrorCode(1);
                baseModel.setErrorMessage("BackEnd diyorki -> Bu kullanıcı adı ya da parola yalnış");
            }

        } catch (Exception e) {
            e.printStackTrace();
            baseModel.setErrorCode(1);
            baseModel.setErrorMessage("Giriş başarısız. " + e.getClass().getName() + " " + e.getMessage());
        }
        return baseModel;

    }



    @RequestMapping(value = "/Getirid/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {

        return userServices.KullaniciGetir(id);
    }


    @RequestMapping(value = "/Delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userServices.kullaniciDel(userServices.KullaniciGetir(id));
    }


}
