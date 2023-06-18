package com.fourtk.productapi.dtos.requesties;

import com.fourtk.productapi.dtos.responses.CategoryResponse;
import com.fourtk.productapi.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private double price;
    @NotBlank
    private String description;
    @NotBlank
    private String productIdentifier;
    @NotNull
    private CategoryResponse category;

    public static ProductRequest convert(Product product){
        ProductRequest request = new ProductRequest();
        request.setId(product.getId());
        request.setName(product.getName());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());
        request.setProductIdentifier(product.getProductIdentifier());
        if (product.getCategory() != null){
            request.setCategory(
                    CategoryResponse.convert(product.getCategory()));
        }
        System.out.println(request);
        return request;
    }
}
