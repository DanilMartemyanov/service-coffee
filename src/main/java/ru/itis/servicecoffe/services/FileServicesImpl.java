package ru.itis.servicecoffe.services;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.models.FileInfo;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.repositories.FileInfoRepositories;
import ru.itis.servicecoffe.repositories.ProductRepositories;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Component
public class FileServicesImpl implements FileServices {
    @Autowired
    FileInfoRepositories fileInfoRepositories;
    @Autowired
    ProductRepositories productRepositories;



    @Value("${storage.path}")
    private String storagePath;
    @Transactional // полностью должен выполниться
    @Override
    public String upload(MultipartFile multipartFile, ProductDto productDto) {
        try {
            String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            String storageName = UUID.randomUUID().toString() +  extension;

            FileInfo fileInfo = FileInfo.builder()
                    .type(multipartFile.getContentType())
                    .originalFileName(multipartFile.getOriginalFilename())
                    .storageFileName(storageName)
                    .size(multipartFile.getSize())
                    .url(storagePath  + storageName)
                    .product(ProductDto.fromProductDto(productDto))
                    .build();
            Files.copy(multipartFile.getInputStream(), Paths.get(storagePath, storageName));
            fileInfoRepositories.save(fileInfo);
            return fileInfo.getStorageFileName();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);

        }
    }

    @Override
    public void showFile(String storageFileName, HttpServletResponse httpServletResponse) {
        FileInfo fileInfo = fileInfoRepositories.findByStorageFileName(storageFileName);
        httpServletResponse.setContentType(fileInfo.getType());
        try {
            IOUtils.copy(new FileInputStream(fileInfo.getUrl()), httpServletResponse.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
