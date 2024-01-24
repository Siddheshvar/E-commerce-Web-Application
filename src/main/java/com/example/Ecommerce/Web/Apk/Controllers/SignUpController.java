package com.example.Ecommerce.Web.Apk.Controllers;

import com.example.Ecommerce.Web.Apk.Modules.SignUp;
import com.example.Ecommerce.Web.Apk.Services.SignUpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpServices signUpServices;

    public SignUpController(SignUpServices signUpServices) {
        this.signUpServices = signUpServices;
    }

    @PostMapping("/create")
    public ResponseEntity<SignUp> createUser(@RequestBody SignUp signUp){
        return new ResponseEntity<>(this.signUpServices.createUser(signUp),HttpStatus.OK);
    }

    @GetMapping("/getusers")
    public List<SignUp> getUsers(){
        return signUpServices.getUsers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SignUp> getUserById(@PathVariable("id") long id){
        return new ResponseEntity<SignUp>(this.signUpServices.getUserById(id),HttpStatus.OK);
    }

    @PutMapping(("/update/{id}"))
    public ResponseEntity<SignUp> updateUserById(@PathVariable("id") long id,
                                                 @RequestBody SignUp signUp){
        return new ResponseEntity<>(this.signUpServices.updateUserById(signUp,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SignUp> deleteUserById(@PathVariable("id") long id){
        signUpServices.deleteUserById(id);
        return new ResponseEntity<SignUp>(HttpStatus.OK);
    }

}
