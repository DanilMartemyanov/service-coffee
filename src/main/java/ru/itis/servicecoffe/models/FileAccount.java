package ru.itis.servicecoffe.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalFileName;
    private String storageFileName;
    private String type;
    private Long size;
    private String url;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
