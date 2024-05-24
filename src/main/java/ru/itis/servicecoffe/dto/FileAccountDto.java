package ru.itis.servicecoffe.dto;

import lombok.*;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.FileAccount;
import ru.itis.servicecoffe.models.FileInfo;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileAccountDto {
    private Long id;
    private String originalFileName;
    private String storageFileName;
    private String type;
    private Long size;
    private String url;
    private Account account;

    public static FileAccountDto from(FileAccount fileAccount){
        return FileAccountDto.builder()
                .id(fileAccount.getId())
                .originalFileName(fileAccount.getOriginalFileName())
                .storageFileName(fileAccount.getStorageFileName())
                .size(fileAccount.getSize())
                .type(fileAccount.getType())
                .account(fileAccount.getAccount())
                .build();
    }

    public static List<FileAccountDto> of(List<FileAccount> images){
        return images.stream().map(FileAccountDto::from).collect(Collectors.toList());
    }
}
