package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.Account;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByRecoveryCode(String code);

}