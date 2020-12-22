package ru.geekbrain.market.service;




import ru.geekbrain.market.domain.Order;
import ru.geekbrain.market.domain.User;
import ru.geekbrain.market.dto.OrderDto;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, List<Long> productIds);
    OrderDto getOrderById(Long id);
}