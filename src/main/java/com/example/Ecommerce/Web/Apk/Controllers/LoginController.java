package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.Login;
import com.example.Ecommerce.Web.Apk.Services.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logins")
public class LoginController {
    @Autowired
    private LoginServices loginServices;
    public LoginController(LoginServices loginServices) {
        this.loginServices = loginServices;
    }

    @PostMapping("/save")
    public ResponseEntity<Login> saveUser(@RequestBody Login login){
        return new ResponseEntity<>(this.loginServices.createUser(login), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Login> getAllUsers(){
        return loginServices.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Login> getUserById(@PathVariable("id") long id){
        return new ResponseEntity<Login>(this.loginServices.getUserById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Login> updateUserById(@PathVariable("id") long id,
                                                @RequestBody Login login){
        return new ResponseEntity<Login>(this.loginServices.updateUserById(login,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Login> deleteUserById(@PathVariable("id") long id){
        loginServices.deleteUserById(id);
        return new ResponseEntity<Login>(HttpStatus.OK);
    }
}
