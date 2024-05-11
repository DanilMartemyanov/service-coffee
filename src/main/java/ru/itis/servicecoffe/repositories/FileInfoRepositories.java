package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.FileInfo;

public interface FileInfoRepositories extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String storageFileName);
}
