package com.example.dynamotest.repository;

import com.example.dynamotest.entity.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findAll();
}
