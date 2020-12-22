package ru.geekbrain.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrain.market.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
