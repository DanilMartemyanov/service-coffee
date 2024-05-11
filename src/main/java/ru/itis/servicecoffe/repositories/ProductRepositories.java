package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.Product;

public interface ProductRepositories extends JpaRepository<Product, Long> {
    Product findByName(String productName);
}
