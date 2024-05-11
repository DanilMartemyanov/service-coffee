package ru.itis.servicecoffe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

@Controller
public class ProductControllers {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    FileServices fileServices;
    @GetMapping("/addProduct")
    public String getAddProductPage(Model model){
        model.addAttribute("categories", categoryService.getCategories());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("file")MultipartFile file, ProductForm productForm){
        System.out.println("запрос по продукту");
        ProductDto productDto = productService.addProduct(productForm);
        System.out.println(productDto.getName());
        System.out.println("-----------");
        System.out.println("запрос по файлу");
        fileServices.upload(file, productDto);
        return "redirect:/addProduct";
    }

    @PostMapping("/cardProduct")
    public ResponseEntity<ProductDto> getCardProduct(@RequestBody CardNameProductForm cardNameProductForm){
        ProductDto productDto = productService.getProductDto(cardNameProductForm.getNameProduct());
        System.out.println("---------");
        System.out.println(productDto.getPrice());
        System.out.println("---------");
        return ResponseEntity.ok(productDto);
    }


}
