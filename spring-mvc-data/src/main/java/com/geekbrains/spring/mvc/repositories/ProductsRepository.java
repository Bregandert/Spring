package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    Product findOneByName(String name);
    List<Product> findAllByPriceGreaterThan(int minPrice);

    List<Product> findAllByPriceLessThan(int maxPrice);

//    List<Product> findAll
}