package ru.geekbrain.market.service;



import org.springframework.stereotype.Service;
import ru.geekbrain.market.dao.OrderRepository;
import ru.geekbrain.market.dao.ProductRepository;
import ru.geekbrain.market.domain.Order;
import ru.geekbrain.market.domain.OrderDetails;
import ru.geekbrain.market.domain.Product;
import ru.geekbrain.market.domain.User;
import ru.geekbrain.market.dto.OrderDetailsDto;
import ru.geekbrain.market.dto.OrderDto;
import ru.geekbrain.market.mapper.OrderDetailsMapper;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDetailsMapper orderDetailsMapper = OrderDetailsMapper.MAPPER;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Order createOrder(User user, List<Long> productIds) {
        Order order = new Order();
        order.setUser(user);
        List<OrderDetailsDto> detailsDtos = getOrderDetailsDtosByProductIds(order, productIds);
        List<OrderDetails> details = orderDetailsMapper.toOrderDetails(detailsDtos);
        order.setDetails(details);
        return orderRepository.save(order);
    }



    private List<OrderDetailsDto> getOrderDetailsDtosByProductIds(Order order, List<Long> productIds) {
        List<OrderDetailsDto> detailsDtos = new ArrayList<>();
        for (Long productId : productIds) {
            Product product = productRepository.getOne(productId);
            detailsDtos.add(new OrderDetailsDto(product));
        }
        return detailsDtos;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderDto orderDto = new OrderDto();
        Order order = orderRepository.getOne(id);
        orderDto.setUsername(order.getUser().getName());
        List<OrderDetails> orderDetails = order.getDetails();
        List<OrderDetailsDto> orderDetailsDtos = orderDetailsMapper.fromOrderDetails(orderDetails);
        Map<Long, OrderDetailsDto> mapByProductId = new HashMap<>();
        for (OrderDetailsDto orderDetailsDto : orderDetailsDtos) {
            OrderDetailsDto detail = mapByProductId.get(orderDetailsDto.getProduct().getId());
            if (detail == null) {
                mapByProductId.put(orderDetailsDto.getProduct().getId(), orderDetailsDto);
            } else {
                detail.setAmount(detail.getAmount() + 1.0);
                detail.setSum(detail.getSum() + orderDetailsDto.getProduct().getPrice());
            }
        }
        orderDto.setDetails(new ArrayList<>(mapByProductId.values()));
        orderDto.aggregate();
        return orderDto;
    }
}