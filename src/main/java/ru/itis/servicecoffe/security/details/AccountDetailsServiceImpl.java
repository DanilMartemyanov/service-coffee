package ru.itis.servicecoffe.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.repositories.AccountRepository;

@Component("customUserDetailsImpl")
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("user not found"));
        return new AccountDetailsImpl(account);
    }
}
