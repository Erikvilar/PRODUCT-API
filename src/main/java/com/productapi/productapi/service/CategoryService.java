package com.productapi.productapi.service;




import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productapi.productapi.model.Category;
import com.productapi.productapi.model.dto.CategoryDTO;
import com.productapi.productapi.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public ResponseEntity<List<Category>> findAllCategories(){
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }
    
    public ResponseEntity<CategoryDTO> saveCategory(CategoryDTO categoryDTO){

            if(categoryDTO.getId() == null){
            Category category = new Category();
            category.setName(categoryDTO.getName());
            return ResponseEntity.ok(new CategoryDTO(categoryRepository.save(category))); 
            }else{
                return ResponseEntity.badRequest().build();
            }
           
    }
    
    public ResponseEntity<CategoryDTO> updateCategory(CategoryDTO categoryDTO, String id){

         
            if(id == null){
                System.out.println("Categoria nula");
                return ResponseEntity.badRequest().build();
            }
            Category category = categoryRepository.findById(new ObjectId(id)).get();
            category.setName(categoryDTO.getName());
            category.setId(new ObjectId(id));
            return ResponseEntity.ok(new CategoryDTO(categoryRepository.save(category)));
    }
    
    public ResponseEntity<?> deleteCategory(String id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        }
        categoryRepository.deleteById(new ObjectId(id));
        return ResponseEntity.ok("Categoria deletada de id: "+id);
        
    }

    public Page<CategoryDTO> getAllPage(Pageable page) {
        Page<Category> users = categoryRepository.findAll(page);
        return users.map(CategoryDTO::convert);
    }

    
}
