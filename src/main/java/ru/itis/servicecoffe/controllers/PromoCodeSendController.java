package ru.itis.servicecoffe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.servicecoffe.dto.PhoneForm;
import ru.itis.servicecoffe.services.AccountService;

@Controller
public class PromoCodeSendController {
    @Autowired
    AccountService accountService;
    @GetMapping("/sms/promoCode")
    public String getSmsPage(){
        return "sms";
    }

    @PostMapping("/sms/promoCode")
    public String getNumberPhone(PhoneForm phoneForm){
        accountService.sendPromoCode(phoneForm);
        return "redirect:/main";
    }
}
