package ru.itis.servicecoffe.services;

import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductForm;
import ru.itis.servicecoffe.models.Product;

public interface ProductService {
    ProductDto addProduct(ProductForm productForm);
    ProductDto getProductDto(String productName);
}
