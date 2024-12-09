package com.productapi.productapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.productapi.productapi.model.dto.ProductDTO;
import com.productapi.productapi.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;







@RequiredArgsConstructor
@RequestMapping("product")
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findProducts() {
        return productService.findAllProducts();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ProductDTO> getMethodName(@PathVariable("id") String id) {
        return productService.findProductById(id);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id")String id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO, id);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProduct(id);
    }
    
    @GetMapping("/pageable")
    public Page<ProductDTO> pageableProduct(Pageable page) {
        return productService.getAllPage(page);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDTO>> getCategory(@PathVariable("id") String id) {
        return productService.getCategoryById(id);
    }
    @GetMapping("/{productIdentifier}")
    public ResponseEntity<List<ProductDTO>> getProductIdentifier(@PathVariable("productIdentifier") String productIdentifier) {
        return productService.getProductIdentifier(productIdentifier);
    }
    

    
    

}
