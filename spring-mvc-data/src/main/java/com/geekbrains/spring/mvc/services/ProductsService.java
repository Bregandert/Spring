package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.exceptions.ProductNotFoundException;
import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public Product findById(int id) {
        return productsRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't found student with id = " + id));
    }



    public Product findByName(String name) {
        return productsRepository.findOneByName(name);
    }

    public List<Product> findByMinPrice(int minPrice) {
        return productsRepository.findAllByPriceGreaterThan(minPrice);
    }

    public List<Product> findByMaxPrice(int maxPrice) {
        return productsRepository.findAllByPriceLessThan(maxPrice);
    }

    public List<Product> findAllASC(){
        return productsRepository.findAll(Sort.by(Sort.Direction.ASC,"Price"));
    }
    public List<Product> findAllDESC(){
        return productsRepository.findAll(Sort.by(Sort.Direction.DESC,"Price"));
    }

    public Page<Product> findByPage(int pageNumber, int pageSize) {
        return productsRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }
public List<Product> findAll(){

    return productsRepository.findAll();
}


    public Page<Product> findAll(Specification<Product> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
        return productsRepository.findAll(spec, PageRequest.of(page - 1, 15));
    }
}
