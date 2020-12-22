package ru.geekbrain.market.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrain.market.domain.OrderStatus;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private long id;
    private LocalDateTime created;
    private String user;
    private double sum;
    private OrderStatus status;
    private List<OrderDetailsDto> details = new ArrayList<>();

    public void aggregate(){
        this.amount = details.size();
        this.sum = details.stream()
                .map(OrderDetailsDto::getSum)
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}