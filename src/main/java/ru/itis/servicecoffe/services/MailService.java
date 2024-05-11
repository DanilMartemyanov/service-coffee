package ru.itis.servicecoffe.services;

public interface MailService {
    void sendEmailForConfirm(String email, String code);
}
