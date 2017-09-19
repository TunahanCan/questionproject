package com.etaration.ProServices;

import com.etaration.ProEntity.User;
import com.etaration.ProRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tunahan on 10.07.2017.
 */

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;


    public List<User> AllUser()
    {
        return (List<User>) userRepository.findAll();
    }


    public void KullaniciOlustur(User user)
    {
        userRepository.save(user);
    }

    public User KullaniciGetir(String name)
    {
        return userRepository.findByUsername(name);
    }

    public User KullaniciGetir(long id)
    {
        return userRepository.findById(id);
    }

    public void kullaniciDel(User user)
    {
        userRepository.delete(KullaniciGetir(user.getId()));
    }



}
