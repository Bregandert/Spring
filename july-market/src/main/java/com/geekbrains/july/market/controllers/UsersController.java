package com.geekbrains.july.market.controllers;


import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

  @Autowired
        public UsersController(UsersService usersService) {
      this.usersService = usersService;

  }
      @GetMapping
      public String getAllUsers(Model model) {
          List<User> users = usersService.getAllUsers();
          model.addAttribute("users", users);
          return "all_users";
      }

//
//        @PostMapping("/info")
//        public List<User> (@ModelAttribute Long id) {
//            usersService.getUsersByIds(id);
//            return "redirect:/users/";
//        }

    @GetMapping("/info/{id}")
    public String showInfoForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", usersService.findById(id));
        return "info_user_form";
    }

    }




