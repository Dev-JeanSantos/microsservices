package com.fourtk.productapi.dtos.responses;

import com.fourtk.productapi.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {

    private Long id;

    public static CategoryResponse convert(Category category){
        CategoryResponse request = new CategoryResponse();
        request.setId(category.getId());
        return  request;
    }

}
