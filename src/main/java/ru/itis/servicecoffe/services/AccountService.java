package ru.itis.servicecoffe.services;


import ru.itis.servicecoffe.dto.EmailForm;
import ru.itis.servicecoffe.dto.PhoneForm;
import ru.itis.servicecoffe.dto.SignUpForms;


public interface AccountService {
    void singUp(SignUpForms signUpForms);

    void sendPromoCode(PhoneForm phoneForm);

    void sendEmailForConfirm(EmailForm emailForm);

    boolean checkAccount(String code);
}
