package com.productapi.productapi.repositories;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.productapi.productapi.model.Category;

public interface CategoryRepository extends MongoRepository<Category, ObjectId> {


    
}
