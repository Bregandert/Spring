package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

        @Column(name = "phone")
        private String phone;

        public User(Long id, String name, String email, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone =phone;
        }
    }

