package ru.geekbrain.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrain.market.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
}
