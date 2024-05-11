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
            Long categoryId = (long) productForm.getCategory();
            System.out.println("тут ошибка");
            Category category = categoryRepositories.findById(categoryId).orElseThrow(()-> new EntityNotFoundException("Категория не найдена"));
            System.out.println("----------");
            System.out.println(category.getName());
            Product product = Product.builder()
                    .name(productForm.getNameProduct())
                    .compound(productForm.getCompound())
                    .price(productForm.getPrice())
                    .cookingTime(productForm.getCookingTime())
                    .category(category)
                    .build();
            productRepositories.save(product);
            Product productForfile = productRepositories.findByName(product.getName());
            return ProductDto.from(productForfile);
        }catch (RuntimeException e){
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
