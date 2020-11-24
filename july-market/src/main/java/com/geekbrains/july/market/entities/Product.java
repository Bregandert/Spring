package com.geekbrains.july.market.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;
//
//    @Column(name = "category")
//    private long category;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public Product(Long id, String title, Category category, int price) {
        this.id = id;
        this.title = title;
        this.category=category;
        this.price = price;

    }
}
