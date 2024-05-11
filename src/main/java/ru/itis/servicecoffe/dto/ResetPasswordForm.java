package ru.itis.servicecoffe.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResetPasswordForm {
    private String mainPassword;
    private String repeatPassword;
    private String codeForResetPassword;
}
