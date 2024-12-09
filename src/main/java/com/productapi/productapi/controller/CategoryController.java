package com.productapi.productapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapi.productapi.model.Category;
import com.productapi.productapi.model.dto.CategoryDTO;
import com.productapi.productapi.model.dto.ProductDTO;
import com.productapi.productapi.service.CategoryService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;





@RequestMapping("category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>>findCategories() {
        return categoryService.findAllCategories();
    }
    
    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.saveCategory(categoryDTO);
    }
    
    @PutMapping("/id/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") String id, @RequestBody CategoryDTO categoryDTO) {
            return categoryService.updateCategory(categoryDTO,id);
        
    }
    
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id){
        return categoryService.deleteCategory(id);
    }
     
    @GetMapping("/pageable")
    public Page<CategoryDTO> pageableCategory(Pageable page) {
        return categoryService.getAllPage(page);
    }

}
