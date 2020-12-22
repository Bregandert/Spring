package ru.geekbrain.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrain.market.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOneById(Long id);
}