package ru.itis.servicecoffe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.servicecoffe.models.Order;
import ru.itis.servicecoffe.models.Product;

import java.util.List;

public interface OrderRepositories extends JpaRepository<Order, Long> {
    List<Order> findByAccountId(Long accountId);
}
