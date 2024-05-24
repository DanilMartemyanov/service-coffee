package ru.itis.servicecoffe.services;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.FileInfoDto;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.models.FileInfo;
import ru.itis.servicecoffe.models.Product;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

public interface FileServices {
    String upload(MultipartFile multipartFile, ProductDto productDto);

    void showFile(String storageFileName, HttpServletResponse httpServletResponse);

    String getStorageFileName(Long productId);

    List<FileInfoDto> getFilesInfo();

    List<FileInfoDto> getFilesInfoByProductId(Set<Long> keys);



}
