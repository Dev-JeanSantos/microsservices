package com.fourtk.productapi.dtos.responses;

import com.fourtk.productapi.dtos.requesties.CategoryRequest;
import com.fourtk.productapi.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String name;
    private double price;
    private String description;
    private String productIdentifier;
    private CategoryRequest category;

    public static ProductResponse convert(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        productResponse.setProductIdentifier(product.getProductIdentifier());
        if(product.getCategory() != null){
            productResponse.setCategory(
                    CategoryRequest.convert(product.getCategory()));
        }
        return productResponse;
    }

}
