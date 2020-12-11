package ru.geekbrain.market.service;


import ru.geekbrain.market.domain.Bucket;
import ru.geekbrain.market.domain.User;
import ru.geekbrain.market.dto.BucketDto;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);
    BucketDto getBucketByUser(String name);
}
