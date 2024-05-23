package ru.itis.servicecoffe.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.servicecoffe.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface ProductRepositories extends JpaRepository<Product, Long> {
    Product findByName(String productName);
    List<Product> findByIdIn(Set<Long> keys);

    @Query("select product from Product product where (:q = 'empty' or UPPER(product.name) like UPPER(concat('%', :q, '%'))) ")
    Page<Product> search(@Param("q") String q, Pageable pageable);
}
