package ru.itis.servicecoffe.services;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.*;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.models.Role;
import ru.itis.servicecoffe.models.StateUser;
import ru.itis.servicecoffe.repositories.AccountRepository;
import ru.itis.servicecoffe.repositories.ProductRepositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SmsService smsService;
    @Autowired
    MailService mailService;
    @Autowired
    ProductRepositories productRepositories;
    @Override
    public void singUp(SignUpForms signUpForms) {
        Account account = Account.builder()
                .email(signUpForms.getEmail())
                .hashPassword(passwordEncoder.encode(signUpForms.getPassword()))
                .Role(Role.USER)
                .StateUser(StateUser.ACTIVE)
                .recoveryCode(UUID.randomUUID().toString())
                .build();
        accountRepository.save(account);
    }

    @Override
    public void sendPromoCode(PhoneForm phoneForm) {
        String promoCode = UUID.randomUUID().toString();
        smsService.sendMessage(phoneForm.getPhone(), "Ваш промокод: " + promoCode);
    }

    @Override
    public void sendEmailForConfirm(EmailForm emailForm) {
        Account account = accountRepository.findByEmail(emailForm.getEmail()).orElseThrow();
        String uniqueCode = account.getRecoveryCode();
        String email  = emailForm.getEmail();
        mailService.sendEmailForConfirm(email, uniqueCode);
    }

    @Override
    public boolean checkAccount(String code) {
        Account account = accountRepository.findByRecoveryCode(code).orElseThrow();
        System.out.println(code);
        System.out.println(account);
        if (account != null){
            System.out.println("зашёл");
            return true;
        }
        return false;
    }

    @Override
    public Long addFavoriteProduct(ProductIdForm productIdForm, String username) {
        Account account = accountRepository.findByEmail(username).orElseThrow();
        Product product = productRepositories.findById(productIdForm.getProductId()).orElseThrow();
        account.getProducts().add(product);
        accountRepository.save(account);
        System.out.println("addfavorite");
        return account.getId();
    }

    @Override
    public AccountDto findByUserName(String username) {
        return AccountDto.from(accountRepository.findByEmail(username).orElseThrow());
    }
}
