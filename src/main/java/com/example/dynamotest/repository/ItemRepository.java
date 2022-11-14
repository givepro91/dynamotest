package com.example.dynamotest.repository;

import com.example.dynamotest.entity.Item;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ItemRepository extends CrudRepository<Item, String> {
    Optional<Item> findById(String id);
}
