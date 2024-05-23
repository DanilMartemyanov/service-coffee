package ru.itis.servicecoffe.services;


import ru.itis.servicecoffe.dto.*;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.Product;


public interface AccountService {
    void singUp(SignUpForms signUpForms);

    void sendPromoCode(PhoneForm phoneForm);

    void sendEmailForConfirm(EmailForm emailForm);

    boolean checkAccount(String code);

    Long addFavoriteProduct(ProductIdForm productIdForm, String username);

    AccountDto findByUserName(String username);
}
