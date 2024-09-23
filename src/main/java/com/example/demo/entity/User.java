package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

   
}
