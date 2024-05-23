package ru.itis.servicecoffe.models;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "booking")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private String orderDeliveryTime;
    private StatusOrder statusOrder;
    private String uuid;
//    private  HashMap<Long, Integer> productCountId;
    @ManyToMany
    @JoinTable(name = "productsInOrders",
            joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//    private List<Product> orderProducts;


}
