package ru.itis.servicecoffe.services;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.FileAccount;
import ru.itis.servicecoffe.models.FileInfo;
import ru.itis.servicecoffe.repositories.AccountRepository;
import ru.itis.servicecoffe.repositories.FileAccountRepositories;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileAccountServiceImpl implements FileAccountService{
    @Value("${storage.path}")
    private String storagePath;
    @Autowired
    FileAccountRepositories fileAccountRepositories;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void showFile(String storageFileName, HttpServletResponse httpServletResponse) {
        FileAccount fileInfo = fileAccountRepositories.findByStorageFileName(storageFileName);
        httpServletResponse.setContentType(fileInfo.getType());
        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), httpServletResponse.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String uploadFileAccount(MultipartFile multipartFile, String username) {
        try {
            String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            String storageName = UUID.randomUUID().toString() +  extension;
            Account account = accountRepository.findByEmail(username).orElseThrow();
            FileAccount fileAccount = FileAccount.builder()
                    .type(multipartFile.getContentType())
                    .originalFileName(multipartFile.getOriginalFilename())
                    .storageFileName(storageName)
                    .size(multipartFile.getSize())
                    .url(storagePath  + storageName)
                    .account(account)
                    .build();
            Files.copy(multipartFile.getInputStream(), Paths.get(storagePath, storageName));
            fileAccountRepositories.save(fileAccount);
            return fileAccount.getStorageFileName();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);

        }

    }

    @Override
    public String getStorageFileNameAccount(String username) {
        Account account = accountRepository.findByEmail(username).orElseThrow();
        FileAccount fileInfo = fileAccountRepositories.findByAccountId(account.getId());
        return fileInfo.getStorageFileName();
    }
}
