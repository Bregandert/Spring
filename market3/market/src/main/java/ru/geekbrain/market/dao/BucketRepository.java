package ru.geekbrain.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrain.market.domain.Bucket;


public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
