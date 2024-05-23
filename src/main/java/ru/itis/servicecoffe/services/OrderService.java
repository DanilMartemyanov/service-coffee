package ru.itis.servicecoffe.services;

import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.OrderDto;
import ru.itis.servicecoffe.dto.OrderForm;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.models.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


public interface OrderService {
    OrderDto addOrder(Set<Long> products, String username, List<Integer> counts );
}
