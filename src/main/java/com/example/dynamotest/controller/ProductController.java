package com.example.dynamotest.controller;

import com.example.dynamotest.entity.Product;
import com.example.dynamotest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/get/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
