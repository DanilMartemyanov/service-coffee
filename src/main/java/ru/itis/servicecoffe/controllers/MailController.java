package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.servicecoffe.dto.EmailForm;
import ru.itis.servicecoffe.dto.ResetPasswordForm;
import ru.itis.servicecoffe.services.AccountService;
import ru.itis.servicecoffe.services.ResetService;

@Controller
public class MailController {
    @Autowired
    AccountService accountService;
    @Autowired
    ResetService resetService;
    @GetMapping("/confirm/{confirmCode}")
    public String confirmPage(@PathVariable("confirmCode") String code){
        System.out.println(code);
        if(accountService.checkAccount(code)){
            return "redirect:/resetPassword";
        }else {
            return "redirect/:signIn";
        }
    }

    @GetMapping("recoveryAccount")
    public String getRecoveryPage(){
        return "recoveryAccount";
    }

    @PostMapping("/recoveryAccount")
    public String getEmailRecovery(EmailForm emailForm){
        accountService.sendEmailForConfirm(emailForm);
        return "redirect:/main";
    }

    @GetMapping("/resetPassword")
    public String getResetPasswordPage(){
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPasswordAccount(ResetPasswordForm resetPasswordForm){
        resetService.resetPasswordAccount(resetPasswordForm);
        return "redirect:/signIn";
    }

}
