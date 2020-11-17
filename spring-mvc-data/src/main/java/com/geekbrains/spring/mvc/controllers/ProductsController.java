package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.specifications.ProductSpecifications;
import com.geekbrains.spring.mvc.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
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
    public String showAllProducts(Model model,
                                  @RequestParam(name = "p", defaultValue = "1") Integer pageNumber,
                                  @RequestParam(name = "min_price", required = false) Integer minPrice,
                                  @RequestParam(name = "max_price", required = false) Integer maxPrice) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.priceGEThan(minPrice));

        }
        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceLEThan(maxPrice));


        }

        List<Product> products = productsService.findAll(spec, pageNumber).getContent();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct) {
        productsService.saveOrUpdate(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productsService.findById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(@ModelAttribute Product modifiedProduct) {
        productsService.saveOrUpdate(modifiedProduct);
        return "redirect:/products/";
    }

    @GetMapping("/info_by_name")
    @ResponseBody
    public Product infoByName(@RequestParam String name) {
        return productsService.findByName(name);
    }

    //3. С помощью GET-запроса указывать фильтрацию по:
    //        a. только минимальной,
    @GetMapping("/find_by_min_price")
    @ResponseBody
    public List<Product> findByMinPrice(@RequestParam int minPrice) {
        return productsService.findByMinPrice(minPrice);
    }

    //        b. только максимальной,
    @GetMapping("/find_by_max_price")
    @ResponseBody
    public List<Product> findByMaxPrice(@RequestParam int maxPrice) {
        return productsService.findByMaxPrice(maxPrice);
    }


}