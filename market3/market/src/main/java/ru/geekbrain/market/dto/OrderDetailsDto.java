package ru.geekbrain.market.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrain.market.domain.Product;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDto {
    private String title;
    private Product product;
    private Double price;
    private Double amount;
    private Double sum;

    public OrderDetailsDto(Product product) {
        this.product = product;
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.amount = 1.0;
        this.sum = product.getPrice();
    }
}