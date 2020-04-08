package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserTestController
{
   @PostMapping("/addUser")
   public  Result addUser(@RequestBody @Valid User adduser){
       Result<User>  regResult = new Result<>(adduser);
       return regResult;
   }

    @PostMapping("/regUser")
    public Result registerByForm(@Valid @RequestBody User registerUser){
       Result<User> regResult = new Result<>(registerUser);
       return  regResult;
    }
}
