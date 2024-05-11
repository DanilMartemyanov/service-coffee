package ru.itis.servicecoffe.services;

import ru.itis.servicecoffe.dto.ResetPasswordForm;

public interface ResetService {
    void resetPasswordAccount(ResetPasswordForm resetPasswordForm);
}
