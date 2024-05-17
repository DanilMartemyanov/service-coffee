package ru.itis.servicecoffe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductForm;
import ru.itis.servicecoffe.models.Category;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.repositories.CategoryRepositories;
import ru.itis.servicecoffe.repositories.ProductRepositories;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepositories productRepositories;
    @Autowired
    CategoryRepositories categoryRepositories;
    @Override
    public ProductDto addProduct(ProductForm productForm) {
        try{
//            Long categoryId = (long) productForm.getCategory();
//            System.out.println(categoryId);
//            Category category = categoryRepositories.findById(categoryId).orElseThrow(()-> new EntityNotFoundException("Категория не найдена"));
            Product product = Product.builder()
                    .name(productForm.getNameProduct())
                    .compound(productForm.getCompound())
                    .price(Integer.parseInt(productForm.getPrice()))
                    .cookingTime(Integer.parseInt(productForm.getCookingTime()))
//                    .category(category)
                    .build();
            productRepositories.save(product);
            Product productForfile = productRepositories.findByName(product.getName());
            System.out.println(productForfile.getId());
            System.out.println(productForfile.getName());
            return ProductDto.from(productForfile);
        }catch (IllegalArgumentException e){
            System.out.println("тут");
            System.out.println(e.getMessage());
            return null;
            // написать свой класс с исключениями
        }

    }

    @Override
    public ProductDto getProductDto(String productName) {
        return ProductDto.from(productRepositories.findByName(productName));
    }
}
