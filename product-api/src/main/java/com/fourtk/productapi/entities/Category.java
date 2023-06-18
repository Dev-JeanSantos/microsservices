package com.fourtk.productapi.entities;

import com.fourtk.productapi.dtos.requesties.CategoryRequest;
import com.fourtk.productapi.dtos.responses.CategoryResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    public static Category  convert(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setId(categoryRequest.getId());
        category.setName(categoryRequest.getName());
        return category;
    }
    public static Category  convertResponse(CategoryResponse categoryResponse){
        Category category = new Category();
        category.setId(categoryResponse.getId());
        return category;
    }
}
