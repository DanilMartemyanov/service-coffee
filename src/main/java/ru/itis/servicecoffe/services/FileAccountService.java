package ru.itis.servicecoffe.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileAccountService {
    void showFile(String storageFileName, HttpServletResponse httpServletResponse);
    String uploadFileAccount(MultipartFile multipartFile, String username);
    String getStorageFileNameAccount(String username);
}
