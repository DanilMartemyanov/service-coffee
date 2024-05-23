package ru.itis.servicecoffe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.servicecoffe.dto.OrderDto;
import ru.itis.servicecoffe.dto.ProductDto;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.Order;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.models.StatusOrder;
import ru.itis.servicecoffe.repositories.AccountRepository;
import ru.itis.servicecoffe.repositories.OrderRepositories;
import ru.itis.servicecoffe.repositories.ProductRepositories;

import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class OrderServiceImpl implements OrderService{
    @Autowired
    ProductRepositories productRepositories;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ConvertTimeImpl convertTime;
    @Autowired
    OrderRepositories orderRepositories;

    @Override
    public OrderDto addOrder(Set<Long> productsKeys, String username, List<Integer> counts ){
        List<Product> products = productRepositories.findByIdIn(productsKeys);
        Account account = accountRepository.findByEmail(username).orElseThrow();
        int orderTimeMinutes = 0;
        for(int i = 0 ; i < counts.size(); i++){
            orderTimeMinutes += products.get(i).getCookingTime() * counts.get(i);
        }
        System.out.println(orderTimeMinutes);
        System.out.println(convertTime.convert(orderTimeMinutes));
        String uniqueCode = UUID.randomUUID().toString();
        Order order = Order.builder()
                .statusOrder(StatusOrder.PREPARE)
                .account(account)
                .orderDeliveryTime(String.valueOf(convertTime.convert(orderTimeMinutes)))
                .uuid(uniqueCode)
                .products(products)
                .build();
        orderRepositories.save(order);
        return OrderDto.from(order);
    }
}
