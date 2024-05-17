package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.servicecoffe.dto.CardNameProductForm;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductForm;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.services.CategoryService;
import ru.itis.servicecoffe.services.FileServices;
import ru.itis.servicecoffe.services.ProductService;
import ru.itis.servicecoffe.services.ProductServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductControllers {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    FileServices fileServices;
    private ProductForm productForm;

    @GetMapping("/addProduct")
    public String getAddProductPage(Model model){
//        model.addAttribute("categories", categoryService.getCategories());
        return "addProduct";
    }

    @PostMapping(value = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody ProductForm productForm){
        ProductDto productDto = productService.addProduct(productForm);
        return ResponseEntity.ok().body(productDto);
    }

//    @PostMapping("/cardProduct/")
//    public ResponseEntity<ProductDto> getCardProduct(@RequestBody CardNameProductForm cardNameProductForm){
//        ProductDto productDto = productService.getProductDto(cardNameProductForm.getNameProduct());
//        System.out.println("---------");
//        System.out.println(productDto.getPrice());
//        System.out.println("---------");
//        return ResponseEntity.ok(productDto);
//    }
//    @GetMapping("/")

//    @PostMapping("/test")
//    public String test(@RequestParam("file")MultipartFile file, ProductForm productForm){
//        System.out.println(productForm.getNameProduct());
//        System.out.println(file);
//        return "redirect:/addProduct";
//    }
}
