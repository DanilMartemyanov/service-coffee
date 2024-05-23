package ru.itis.servicecoffe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.ChangeProductPriceForm;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductForm;
import ru.itis.servicecoffe.dto.ProductIdForm;
import ru.itis.servicecoffe.models.Category;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.repositories.CategoryRepositories;
import ru.itis.servicecoffe.repositories.FileInfoRepositories;
import ru.itis.servicecoffe.repositories.ProductRepositories;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepositories productRepositories;
    @Autowired
    CategoryRepositories categoryRepositories;

    @Autowired
    FileInfoRepositories fileInfoRepositories;

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

    @Override
    public ProductDto getProductDto(Long productId) {
        Product product = productRepositories.findById(productId).orElseThrow();
        return ProductDto.from(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return ProductDto.of(productRepositories.findAll());
    }

    @Override
    public List<ProductDto> getProductsForBasket(Set<Long> keys) {
        return ProductDto.of(productRepositories.findByIdIn(keys));
    }

    @Override
    public void deleteProduct(ProductIdForm productIdForm) {
        if (fileInfoRepositories.existsByProductId(productIdForm.getProductId())){
            System.out.println("deleteproduct");
            fileInfoRepositories.delete(fileInfoRepositories.findByProductId(productIdForm.getProductId()));
        }
        productRepositories.deleteById(productIdForm.getProductId());
    }

    @Override
    public String changeProductPrice(ChangeProductPriceForm changeProductPriceForm) {
        System.out.println("productServicechange");
        Product product = productRepositories.findById(changeProductPriceForm.getProductId()).orElseThrow();
        product.setPrice(changeProductPriceForm.getProductPrice());
        productRepositories.save(product);
        return "Цена товара изменена";
    }

    @Override
    public List<ProductDto> search(Integer size, Integer page, String query, String sortParameter, String directionParameter) {
        Sort.Direction direction = Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Sort.Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }
        if (size == null) {
            size = 3;
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        System.out.println(pageRequest);
        Page<Product> papersPage = productRepositories.search(query, pageRequest);
        return ProductDto.of(papersPage.getContent());
    }

    @Override
    public int totalAmount(List<ProductDto> products, ArrayList<Integer> counts) {
        int totalAmount = 0;
        for(int i = 0 ; i < counts.size(); i++){
            totalAmount += products.get(i).getPrice() * counts.get(i);
        }
        return totalAmount ;
    }
}
