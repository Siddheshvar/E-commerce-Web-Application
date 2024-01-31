package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Login;
import com.example.Ecommerce.Web.Apk.Repositories.LoginRepository;
import com.example.Ecommerce.Web.Apk.Services.LoginServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServicesImpl implements LoginServices {
    @Autowired
    private LoginRepository loginRepository;

    public LoginServicesImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login createUser(Login login) {
        return this.loginRepository.save(login);
    }

    @Override
    public List<Login> getAllUsers() {
        return this.loginRepository.findAll();
    }

    @Override
    public Login getUserById(long id) {
        return this.loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
    }

    @Override
    public Login updateUserById(@NotNull Login login, long id) {
        Login existingUser = loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found"));
        existingUser.setEmailId(login.getEmailId());
        existingUser.setPassword(login.getPassword());

        return this.loginRepository.save(existingUser);
    }

    @Override
    public void deleteUserById(long id) {
        loginRepository.findById(id).orElseThrow(()->
                new RuntimeException("User not found!"));
        loginRepository.deleteById(id);
    }
}
