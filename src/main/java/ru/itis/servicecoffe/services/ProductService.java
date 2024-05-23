package ru.itis.servicecoffe.services;

import ru.itis.servicecoffe.dto.ChangeProductPriceForm;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.dto.ProductForm;
import ru.itis.servicecoffe.dto.ProductIdForm;
import ru.itis.servicecoffe.models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ProductService {
    ProductDto addProduct(ProductForm productForm);
    ProductDto getProductDto(String productName);

    ProductDto getProductDto(Long productId);

    List<ProductDto> getAllProducts();

    List<ProductDto> getProductsForBasket(Set<Long> keys);

    void deleteProduct(ProductIdForm productIdForm);

    String changeProductPrice(ChangeProductPriceForm changeProductPriceForm);
    List<ProductDto> search(Integer size, Integer page, String query, String sort, String direction);

    int totalAmount(List<ProductDto> products, ArrayList<Integer> count);
}
