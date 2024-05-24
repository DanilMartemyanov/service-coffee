package ru.itis.servicecoffe.controllers;

import org.dom4j.rule.Mode;
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
import ru.itis.servicecoffe.dto.*;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.services.CategoryService;
import ru.itis.servicecoffe.services.FileServices;
import ru.itis.servicecoffe.services.ProductService;
import ru.itis.servicecoffe.services.ProductServiceImpl;

import javax.servlet.http.HttpSession;
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
    public String getAddProductPage(Model model) {
//        model.addAttribute("products", productService.getAllProducts());
        return "addProduct";
    }

    @PostMapping(value = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody ProductForm productForm, HttpSession session) {
        ProductDto productDto = productService.addProduct(productForm);
        session.setAttribute("productDto", productDto);
        return ResponseEntity.ok().body(productDto);
    }

    @GetMapping("/cardProduct/{id}")
    public String getCardProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.getProductDto(id));
        model.addAttribute("productPhoto", fileServices.getStorageFileName(id));
        return "cardProduct";
    }

    @GetMapping("/products")
    public String getProductsPages(Model model, @RequestParam(value = "q", required = false) String query) {
            List<ProductDto> productSearch = productService.search(10, 0, query, null, null);
            System.out.println(!productSearch.isEmpty());
            if (productSearch != null) {
                model.addAttribute("products", productSearch);
                model.addAttribute("photos", fileServices.getFilesInfo());
                return "buyProduct";
            }else {
                model.addAttribute("products", productService.getAllProducts());
                model.addAttribute("photos", fileServices.getFilesInfo());
                return "buyProduct";
            }
    }

    @PostMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestBody ProductIdForm productIdForm) {
        productService.deleteProduct(productIdForm);
        return ResponseEntity.ok("Удалено");
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductDto>> getUpdateProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/changeProductPrice")
    public ResponseEntity<String> changeProductPrice(@RequestBody ChangeProductPriceForm changeProductPriceForm) {
        System.out.println("changeProductPrice");
        System.out.println(changeProductPriceForm.getProductPrice());
        return ResponseEntity.ok(productService.changeProductPrice(changeProductPriceForm));
    }

}
