package com.geekbrains.july.market.repositories;

import com.geekbrains.july.market.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
}
