package com.fourtk.productapi.services.impl;

import com.fourtk.productapi.dtos.requesties.ProductRequest;
import com.fourtk.productapi.dtos.responses.ProductResponse;
import com.fourtk.productapi.entities.Category;
import com.fourtk.productapi.entities.Product;
import com.fourtk.productapi.repositories.CategoryRepository;
import com.fourtk.productapi.repositories.ProductRepository;
import com.fourtk.productapi.services.IProductService;
import com.fourtk.productapi.services.exceptions.ResourcesNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductRequest save(ProductRequest request) {
        Optional<Category> category = categoryRepository.findById(request.getCategory().getId());
        category.orElseThrow(() -> new ResourcesNotFoundException("Category Not Found!"));
        Product product = repository.save(Product.convertRequest(request));
        return ProductRequest.convert(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> lists = repository.findAll();
        return lists.stream().map(ProductResponse::convert).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductsByCategoryId(Long categoryId) {
        try {
            List<Product> products = repository.getProductByCategoryId(categoryId);
            return products.stream().map(ProductResponse::convert).collect(Collectors.toList());
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException("CategoryId Not Found!");
        }
    }


    @Override
    public ProductResponse findByProductByIdentifier(String productIdentifier) {
        Product product = repository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductResponse.convert(product);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = repository.findById(id);
        product.orElseThrow(() -> new ResourcesNotFoundException("Product Not Found!"));
        repository.delete(product.get());
    }
}

