package ru.itis.servicecoffe.dto;


import lombok.*;
import ru.itis.servicecoffe.models.FileInfo;
import ru.itis.servicecoffe.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileInfoDto {
    private Long id;
    private String originalFileName;
    private String storageFileName;
    private String type;
    private Long size;
    private String url;
    private Product product;

    public static FileInfoDto from(FileInfo fileInfo){
        return FileInfoDto.builder()
                .id(fileInfo.getId())
                .originalFileName(fileInfo.getOriginalFileName())
                .storageFileName(fileInfo.getStorageFileName())
                .size(fileInfo.getSize())
                .type(fileInfo.getType())
                .product(fileInfo.getProduct())
                .build();
    }

    public static List<FileInfoDto> of(List<FileInfo> images){
        return images.stream().map(FileInfoDto::from).collect(Collectors.toList());
    }
}
