package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.ProductIdForm;
import ru.itis.servicecoffe.services.AccountService;
import ru.itis.servicecoffe.services.FileAccountService;
import ru.itis.servicecoffe.services.FileServices;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    FileAccountService fileAccountService;
    @GetMapping("/account")
    public String getAccountPage(Model model){
        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("account", accountService.findByUserName(userName));
        return "/account";
    }

    @PostMapping("/addFavoriteProducts")
    public ResponseEntity<Long> addFavoriteProducts(@RequestBody ProductIdForm productIdForm){
        System.out.println(productIdForm.getProductId());
        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok().body(accountService.addFavoriteProduct(productIdForm, userName));
    }

//    @GetMapping("/checkFavoriteProducts/{id}")
//    public ResponseEntity<Integer> checkFavoriteProducts(@PathVariable("id") Long productId){
//        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
//        return ResponseEntity.ok(accountService.)
//    }

    @PostMapping("/addAccountPhoto")
    public ResponseEntity<String> addAccountPhoto(@RequestParam("file") MultipartFile file, Model model){
        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("addAccountPhoto");
        return  ResponseEntity.ok(fileAccountService.uploadFileAccount(file, userName));

    }

    @GetMapping("/getPhotoAcount")
    public ResponseEntity<String> getPhotoAccount(Model model){
        final String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(fileAccountService.getStorageFileNameAccount(userName));
    }

    @GetMapping("/account/images/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response){
        System.out.println(fileName);
        fileAccountService.showFile(fileName, response);
    }

}
