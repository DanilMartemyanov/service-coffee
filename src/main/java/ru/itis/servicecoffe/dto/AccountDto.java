package ru.itis.servicecoffe.dto;

import lombok.*;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.Category;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Long id;
    private String name;

    public static AccountDto from(Account account){
        AccountDto accountDto = AccountDto.builder()
                .id(account.getId())
                .name(account.getEmail())
                .build();
        return accountDto;
    }
}
