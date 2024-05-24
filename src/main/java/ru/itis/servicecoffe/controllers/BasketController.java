package ru.itis.servicecoffe.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.servicecoffe.dto.BasketForm;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductIdForm;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.services.FileServices;
import ru.itis.servicecoffe.services.ProductService;

import javax.servlet.http.HttpSession;

import java.io.Writer;
import java.util.*;

@Controller
public class BasketController {
    @Autowired
    FileServices fileServices;
    @Autowired
    ProductService productService;

    @PostMapping("/basket")
    public void productsBasket(@RequestBody BasketForm basketForm, HttpSession session) {
        // поправить сохранение
        System.out.println("postbasket");
        if (session.getAttribute("basket") == null) {
            Map<Long, Integer> basket = new HashMap<>();
            basket.put(basketForm.getProductId(), basketForm.getCountProduct());
            session.setAttribute("basket", basket);
        }
        HashMap<Long, Integer> basket = (HashMap<Long, Integer>) session.getAttribute("basket");
        basket.put(basketForm.getProductId(), basketForm.getCountProduct());
        System.out.println(basket);

    }
    // поправить переход на корзину
    @GetMapping(value = "/basket", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBasketPage(HttpSession session, Model model) {
        if(session.getAttribute("basket") == null){
            model.addAttribute("basketError", "Ваша корзина пуста :/");
            return "basketError";
        }else{
            System.out.println("getbasket");
            Map<Long, Integer> products = (HashMap<Long, Integer>) session.getAttribute("basket");
            Set<Long> productsIdKey = products.keySet();
            ArrayList<Integer> countProducts = new ArrayList<>(products.values());
            List<ProductDto> productsDto = productService.getProductsForBasket(productsIdKey);
            int totalAmount = productService.totalAmount(productsDto, countProducts);
            model.addAttribute("totalAmount", totalAmount);
            model.addAttribute("countProducts", countProducts);
            model.addAttribute("products", productsDto);
            model.addAttribute("photo", fileServices.getFilesInfoByProductId(productsIdKey));
            return "basket";
        }
    }

    @PostMapping("/updateBasket")
    public ResponseEntity<String> updateBasket(@RequestBody ProductIdForm productIdForm, HttpSession session){
        HashMap<Long, Integer> basket = (HashMap<Long, Integer>) session.getAttribute("basket");
        basket.remove(productIdForm.getProductId());
        return ResponseEntity.ok("Будьте добры, обновите страничку :/");
    }
}
