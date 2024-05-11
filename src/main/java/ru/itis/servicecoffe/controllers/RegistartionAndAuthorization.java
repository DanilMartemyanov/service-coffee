package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.servicecoffe.dto.SignUpForms;
import ru.itis.servicecoffe.services.AccountService;

@Controller
public class RegistartionAndAuthorization {
    @Autowired
    AccountService accountService;
    @GetMapping("/signUp")
    public String getSignUpPage(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpForms signUpForms){
        System.out.println(signUpForms.getRepeatPassword());
        accountService.singUp(signUpForms);
        return "redirect:/signIn";
    }

    @GetMapping("/signIn")
    public String getSignInPage(){
        return "signIn";
    }
}
