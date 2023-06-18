package com.fourtk.productapi.services;

import com.fourtk.productapi.dtos.requesties.ProductRequest;
import com.fourtk.productapi.dtos.responses.ProductResponse;

import java.util.List;

public interface IProductService {
    public ProductRequest save (ProductRequest request);

    public List<ProductResponse> getAllProducts();

    public List<ProductResponse> getProductsByCategoryId(Long categoryId);

    public ProductResponse findByProductByIdentifier(String  productIdentifier);
    public void delete(Long id);

}
