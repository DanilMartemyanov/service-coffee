package ru.itis.servicecoffe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.ResetPasswordForm;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.repositories.AccountRepository;

import java.util.Optional;

@Component
public class ResetServiceImpl implements ResetService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void resetPasswordAccount(ResetPasswordForm resetPasswordForm) {
        Account account = accountRepository.findByRecoveryCode(resetPasswordForm.getCodeForResetPassword()).orElseThrow();
        account.setHashPassword(passwordEncoder.encode(resetPasswordForm.getMainPassword()));
        accountRepository.save(account);
    }
}
