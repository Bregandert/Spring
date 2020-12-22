package ru.geekbrain.market.mapper;



import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.geekbrain.market.domain.OrderDetails;
import ru.geekbrain.market.dto.OrderDetailsDto;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {

    OrderDetailsMapper MAPPER = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetails toOrderDetails(OrderDetailsDto orderDetailsDto);

    @InheritInverseConfiguration
    OrderDetailsDto fromOrderDetails(OrderDetails orderDetails);

    List<OrderDetails> toOrderDetails(List<OrderDetailsDto> orderDetailsDtos);

    List<OrderDetailsDto> fromOrderDetails(List<OrderDetails> orderDetails);
}