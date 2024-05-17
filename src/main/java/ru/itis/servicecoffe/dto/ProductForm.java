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
    private String cookingTime;
    private String price;
//    private int category;
}
