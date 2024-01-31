package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.SignUp;
import com.example.Ecommerce.Web.Apk.Repositories.SignUpRepository;
import com.example.Ecommerce.Web.Apk.Services.SignUpServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class SignUpServicesImpl implements SignUpServices {
//    @Autowired
    private SignUpRepository signUpRepository;

    public SignUpServicesImpl(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @Override
    public SignUp createUser(SignUp signUp) {
        return this.signUpRepository.save(signUp);
    }

    @Override
    public List<SignUp> getUsers() {
        return this.signUpRepository.findAll();
    }

    @Override
    public SignUp getUserById(long id) {
        return this.signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
    }

    @Override
    public SignUp updateUserById(@NotNull SignUp signUp, long id) {
        SignUp oldUser = signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));

        oldUser.setFullName(signUp.getFullName());
        oldUser.setPhoneNo(signUp.getPhoneNo());
        oldUser.setEmailId(signUp.getEmailId());
        oldUser.setCreatePassword(signUp.getCreatePassword());

        return  this.signUpRepository.save(oldUser);
    }

    @Override
    public void deleteUserById(long id) {
        signUpRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
        signUpRepository.deleteById(id);
    }
}
