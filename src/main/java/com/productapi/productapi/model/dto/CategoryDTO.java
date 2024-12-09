package com.productapi.productapi.model.dto;



import com.productapi.productapi.model.Category;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private String id;
    private String name;


    public CategoryDTO(Category category){
        this.id = category.getId().toString();
        this.name = category.getName();
    }
    public static CategoryDTO convert(Category category){
        return new CategoryDTO(category);
    }

}
