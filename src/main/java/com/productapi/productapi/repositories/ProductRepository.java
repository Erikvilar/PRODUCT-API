package com.productapi.productapi.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.productapi.productapi.model.Product;

public interface ProductRepository extends MongoRepository<Product, ObjectId>{
    
    Page<Product> findAll(Pageable page);
    List<Product> findByCategoryId(ObjectId categoryId);
    List<Product> findByProductIdentifier(String productIdentifier);
    
    
}
