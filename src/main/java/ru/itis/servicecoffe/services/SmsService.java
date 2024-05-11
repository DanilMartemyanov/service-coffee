package ru.itis.servicecoffe.services;

public interface SmsService {
    void sendMessage(String phone, String text);
}
