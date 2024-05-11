package ru.itis.servicecoffe.dto;


import lombok.*;

import java.io.File;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductForm {
    private String nameProduct;
    private String compound;
    private int cookingTime;
    private int price;
    private int category;
}
