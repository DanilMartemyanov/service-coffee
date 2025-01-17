package ru.itis.servicecoffe.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.models.Account;

import java.util.Collection;
import java.util.Collections;


public class AccountDetailsImpl  implements UserDetails {
    private Account account;
    public AccountDetailsImpl(Account account){
        this.account = account;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(account.getRole().toString());
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return account.getHashPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return account.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return account.isActive();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
