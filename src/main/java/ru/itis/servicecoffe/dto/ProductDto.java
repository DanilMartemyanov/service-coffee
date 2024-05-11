package ru.itis.servicecoffe.dto;


import lombok.*;
import ru.itis.servicecoffe.models.Category;
import ru.itis.servicecoffe.models.Product;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String compound;
    private int cookingTime;
    private int price;
    private Category category;


    public static ProductDto from(Product product){
        ProductDto productDto = ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .compound(product.getCompound())
                .cookingTime(product.getCookingTime())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
        return productDto;
    }

    public  static List<ProductDto> of(List<Product> products){
        return products.stream().map(ProductDto::from).collect(Collectors.toList());
    }

    public static Product fromProductDto(ProductDto productDto){
        Product product = Product.builder()
                .id(productDto.id)
                .name(productDto.getName())
                .cookingTime(productDto.cookingTime)
                .compound(productDto.getCompound())
                .price(productDto.getPrice())
                .category(productDto.category)
                .build();
        return product;
    }

}
