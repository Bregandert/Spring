package ru.geekbrain.market.service;

import ru.geekbrain.market.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
    void addToUserBucket(Long productId, String username);
}
