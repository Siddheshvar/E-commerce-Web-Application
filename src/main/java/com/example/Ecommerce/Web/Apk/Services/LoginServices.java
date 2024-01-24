package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginServices {
    Login createUser(Login login);
    List<Login> getAllUsers();
    Login getUserById(long id);
    Login updateUserById(Login login, long id);
    void deleteUserById(long id);
}
