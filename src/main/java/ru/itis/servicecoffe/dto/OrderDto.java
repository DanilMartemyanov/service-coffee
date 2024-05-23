package ru.itis.servicecoffe.dto;

import lombok.*;
import ru.itis.servicecoffe.models.Account;
import ru.itis.servicecoffe.models.Order;
import ru.itis.servicecoffe.models.Product;
import ru.itis.servicecoffe.models.StatusOrder;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Account account;
    private String orderDeliveryTime;
    private StatusOrder statusOrder;
    private String uuid;
    private List<Product> products;
    public static OrderDto from(Order order){
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .statusOrder(order.getStatusOrder())
                .orderDeliveryTime(order.getOrderDeliveryTime())
                .account(order.getAccount())
                .products(order.getProducts())
                .uuid(order.getUuid())
                .build();

        return orderDto;
    }

    public  static List<OrderDto> of(List<Order> orders){
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
