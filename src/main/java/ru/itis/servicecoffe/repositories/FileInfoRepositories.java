package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.FileInfo;
import ru.itis.servicecoffe.models.Product;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface FileInfoRepositories extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String storageFileName);

    FileInfo findByProductId(Long productId);
    List<FileInfo> findByProductIdIn(Set<Long> keys);

    boolean existsByProductId(Long productId);

    FileInfo findByAccountId(Long accountId);
}
