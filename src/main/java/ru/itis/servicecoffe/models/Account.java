package ru.itis.servicecoffe.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String hashPassword;
    @Enumerated(value = EnumType.STRING)
    private Role Role;
    @Enumerated(value = EnumType.STRING)
    private StateUser StateUser;
    @OneToMany(mappedBy = "account")
    private List<Order> orders;
    private String phone;//TODO: реализовать сохранение телефона в бд
    private String recoveryCode; //TODO: реализовать обновление уникального кода в бд
    public boolean isActive(){
        return this.StateUser == StateUser.ACTIVE;
    }

    public boolean isBanned(){
        return this.StateUser == StateUser.BANNED;
    }

    public boolean isAdmin(){
        return this.Role == Role.ADMIN;
    }

    public boolean isUser(){
        return this.Role == Role.USER;
    }
    @ManyToMany
    @JoinTable(name = "favoriteProducts",
            joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

    @OneToMany(mappedBy = "account")
    private List<FileAccount> avatars;
}
