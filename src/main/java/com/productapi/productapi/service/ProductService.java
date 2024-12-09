package com.productapi.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.productapi.productapi.model.Category;
import com.productapi.productapi.model.Product;
import com.productapi.productapi.model.dto.ProductDTO;
import com.productapi.productapi.repositories.CategoryRepository;
import com.productapi.productapi.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ResponseEntity<ProductDTO> saveProduct(ProductDTO productDTO) {

        if (productDTO.getId() == null) {
            Optional<Category> categoryId = categoryRepository.findById(new ObjectId(productDTO.getCategoryId()));
            Product product = new Product();

            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setProductIdentifier(productDTO.getProductIdentifier());
            product.setDescription(productDTO.getDescription());
            product.setCategory(categoryId.get());

            return ResponseEntity.ok(new ProductDTO(productRepository.save(product)));
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<ProductDTO> findProductById(String id){
        Product product = productRepository.findById(new ObjectId(id)).get();

        if(product  == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new ProductDTO(product));
    }

    public ResponseEntity<List<ProductDTO>> findAllProducts() {

        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOMapped = 
                products.stream()
                .map(ProductDTO::new) //.map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
        return new ResponseEntity<>(productDTOMapped, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteProduct(String id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        productRepository.deleteById(new ObjectId(id));
        return ResponseEntity.ok("Produto deletado de id: " + id);

    }

    public Page<ProductDTO> getAllPage(Pageable page) {
        Page<Product> users = productRepository.findAll(page);
        return users.map(ProductDTO::convert);
    }

    public ResponseEntity<List<ProductDTO>> getCategoryById(String id){
        List<Product> product = productRepository.findByCategoryId(new ObjectId(id));
        return ResponseEntity.ok(product.stream().map(ProductDTO::new).collect(Collectors.toList()));
    }

    public ResponseEntity<List<ProductDTO>> getProductIdentifier(String productIdentifier){
        List<Product> products = productRepository.findByProductIdentifier(productIdentifier);
        return ResponseEntity.ok(products.stream().map(ProductDTO::new).collect(Collectors.toList()));
    }

      public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO, String id){

         
            if(id == null){
                System.out.println("Categoria nula");
                return ResponseEntity.badRequest().build();
            }
            Product product= productRepository.findById(new ObjectId(id)).get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            productDTO.setDescription(productDTO.getDescription());
            productDTO.setProductIdentifier(productDTO.getProductIdentifier());
            productDTO.setCategoryId(productDTO.getCategoryId());
            product.setId(new ObjectId(id));
            return ResponseEntity.ok(new ProductDTO(productRepository.save(product)));
    }
    
}
