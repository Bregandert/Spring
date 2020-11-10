package com.geekbrains.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1. Разобраться с примером проекта на Spring MVC.
//2. Создать класс Товар (Product), с полями id, title, cost. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id.
//3. Сделать форму для добавления товара в репозиторий и логику работы этой формы.
//4. Сделать страницу, на которой отображаются все товары из репозитория.

@Controller
public class MainController {
    // root (context path) = http://localhost:8189/app
    // GET http://localhost:8189/app/hello?name=Alex
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @ResponseBody
//    public String sayHello(@RequestParam(required = false) String name) {
//        if (name == null) {
//            return "Hello, stranger!!!";
//        }
//        return String.format("Hello, %s!!!", name);
//    }

    // GET http://localhost:8189/app/add?n1=100&n2=1000
//    @RequestMapping(value = "/add", method = RequestMethod.GET)
//    @ResponseBody
//    public Integer addTwoNumbers(@RequestParam(name = "n1") Integer value1, @RequestParam(name = "n2") Integer value2) {
//        return value1 + value2;
//    }

    // GET http://localhost:8189/app/users/info/{id = 2}/confirm
    @GetMapping("/users/info/{id}/confirm")
    @ResponseBody
    public String getUserInfo(@PathVariable Long id) {
        return "User Info #" + id;
    }

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/check/java/data")
    public String checkJavaData(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "check_data";
    }
}
