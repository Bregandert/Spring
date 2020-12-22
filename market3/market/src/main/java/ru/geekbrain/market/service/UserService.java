package ru.geekbrain.market.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.geekbrain.market.domain.User;
import ru.geekbrain.market.dto.UserDto;


import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);
    void save(User user);
    List<UserDto> getAll();

    User findByName(String name);
    void updateProfile(UserDto dto);
}
