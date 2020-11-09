package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// root: http://localhost:8189/app/products

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    // public String saveNewStudent(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
    @PostMapping("/add")
    public String saveNewStudent(@ModelAttribute Product newProduct) {
        productsService.saveOrUpdateProducts(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productsService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyStudent(@ModelAttribute Product modifiedStudent) {
        productsService.saveOrUpdateProducts(modifiedStudent);
        return "redirect:/products/";
    }

    @GetMapping("/X/{id}")
    @ResponseBody
    public Product showXProduct(@PathVariable Long id) {
        return productsService.findById(id);
    }
}
