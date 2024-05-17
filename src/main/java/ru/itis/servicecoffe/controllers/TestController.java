package ru.itis.servicecoffe.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.ProductForm;

@Controller
public class TestController {
    @GetMapping("/test")
    public String getTestPage(){
        return "test";
    }
    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public String posyFile( ProductForm productForm){
        System.out.println("в тесте");
        System.out.println(productForm.getNameProduct());
        return "/addProduct";
    }
}
