package ru.itis.servicecoffe.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String compound;
    private int price;
    private int cookingTime; // в минутах
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<FileInfo> images;

}
