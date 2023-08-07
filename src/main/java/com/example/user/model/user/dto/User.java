package com.example.user.model.user.dto;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private Integer phone;
    @Column
    private String avatar;
    @Column
    private Boolean isdeleted;


}
