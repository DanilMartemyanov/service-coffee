package ru.itis.servicecoffe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForms {
    private String email;
    private String password;
    private String repeatPassword;
}
