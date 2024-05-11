package ru.itis.servicecoffe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TestController {
    @GetMapping("/test")
    public String getTestPage(){
        return "test";
    }
    @PostMapping("/test")
    public void posyFile(@RequestParam("file") MultipartFile file){
        System.out.println(file);
    }

}
