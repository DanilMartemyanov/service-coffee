package ru.itis.servicecoffe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileControllers {
    @PostMapping("/uploadFile")
    public void getFile(@RequestParam("file")MultipartFile file){
        System.out.println(file);
    }
}
