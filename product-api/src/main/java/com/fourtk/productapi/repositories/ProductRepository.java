package com.fourtk.productapi.repositories;

import com.fourtk.productapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getProductByCategoryId(Long categoryId);
    Product findByProductIdentifier(String productIdentifier);
}
