package com.example.Ecommerce.Web.Apk.Services;

import com.example.Ecommerce.Web.Apk.Modules.SignUp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SignUpServices {
    SignUp createUser(SignUp signUp);
    List<SignUp> getUsers();
    SignUp getUserById(long id);
    SignUp updateUserById(SignUp signUp, long id);
    void deleteUserById(long id);
}
