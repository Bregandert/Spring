package ru.geekbrain.market.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrain.market.domain.Order;
import ru.geekbrain.market.dto.OrderDto;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    @InheritInverseConfiguration
    OrderDto fromOrder(Order order);

    List<Order> toOrder(List<OrderDto> orderDtos);

    List<OrderDto> fromOrder(List<Order> order);
}