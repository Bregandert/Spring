package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Category;
import com.geekbrains.july.market.entities.Product;
import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.exceptions.ProductNotFoundException;
import com.geekbrains.july.market.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository (UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<User> getUsersByIds(List<Long> ids) {
        return usersRepository.findAllById(ids);
    }
    public User findById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't found with id = " + id));
    }
    }



