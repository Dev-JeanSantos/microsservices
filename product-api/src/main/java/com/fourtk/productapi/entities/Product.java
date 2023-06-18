package com.fourtk.productapi.entities;

import com.fourtk.productapi.dtos.requesties.ProductRequest;
import com.fourtk.productapi.dtos.responses.ProductResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private String description;
    @Column
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public static Product convertRequest(ProductRequest productRequest) {
        Product product = new Product();
        product.setId(productRequest.getId());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setProductIdentifier(productRequest.getProductIdentifier());
        if(productRequest.getCategory() != null){
            product.setCategory(
                    Category.convertResponse(productRequest.getCategory()));
        }
        return product;
    }
}
