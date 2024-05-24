package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.FileAccount;
import ru.itis.servicecoffe.models.FileInfo;

public interface FileAccountRepositories extends JpaRepository<FileAccount, Long> {
    FileAccount findByStorageFileName(String storageFileName);

    FileAccount findByAccountId(Long accountId);
}
