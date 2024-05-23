package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.services.FileServices;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class FileControllers {
    @Autowired
    FileServices fileServices;
    @PostMapping("/uploadFile")
    public void getFile(@RequestParam("file")MultipartFile file, HttpSession session){
        fileServices.upload(file, (ProductDto) session.getAttribute("productDto"));
    }
    @GetMapping("/images/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response){
        fileServices.showFile(fileName, response);
    }
}
