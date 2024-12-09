package com.productapi.productapi.model.dto;





import com.productapi.productapi.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    
    private String id;
    private String name;
    private String productIdentifier;
    private String description;
    private Double price;
    private String categoryId;


    public ProductDTO(Product product) {
        this.id = product.getId().toString();
        this.name = product.getName();
        this.productIdentifier = product.getProductIdentifier();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.categoryId = product.getCategory().getId().toString();
    
     
    }
    public static ProductDTO convert(Product product){
        return new ProductDTO(product);
    }
}
