package com.fourtk.productapi.dtos.requesties;

import com.fourtk.productapi.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private Long id;

    @NotBlank
    @Size(min = 5, max = 15)
    private String name;

    public static CategoryRequest convert(Category category){
        CategoryRequest request = new CategoryRequest();
        request.setId(category.getId());
        request.setName(category.getName());
        return  request;
    }

}
