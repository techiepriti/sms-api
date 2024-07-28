package com.sms.controller;

import com.sms.model.LoginRequest;
import com.sms.model.Message;
import com.sms.model.User;
import com.sms.service.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UserLogin userLogin;

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest){
        Optional<User> user = this.userLogin.findById(loginRequest.getEmail());
        if(user.isEmpty()){
            Message message = new Message("Error", "No user found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }else {
            if(null != loginRequest.getEmail() && null != loginRequest.getPassword() && loginRequest.getEmail().equals(user.get().getEmail())
                    && loginRequest.getPassword().equals(user.get().getPassword()) ){
                Message message = new Message("Success", "Login Successful!");
                return ResponseEntity.status(HttpStatus.OK).body(message);
            }else {
                Message message = new Message("Unauthorized", "Incorrect Credentials!");
                return ResponseEntity.status(HttpStatus.OK).body(message);
            }

        }
    }

    @PostMapping("/api/signup")
    public  ResponseEntity<Object> signup(@RequestBody User user){
        Optional<User> data = this.userLogin.findById(user.getEmail());
        if(data.isEmpty()){
            if(null != user.getName() && null != user.getEmail() && null != user.getPassword()){
                this.userLogin.save(user);
                return ResponseEntity.status(HttpStatus.OK).body(new Message("Success", "Signup Successful!"));
            }else {
                return ResponseEntity.status(HttpStatus.OK).body(new Message("Invalid Request","Please provide all mandatory fields."));
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(new Message("Fail", "User Already exist"));
    }

}
