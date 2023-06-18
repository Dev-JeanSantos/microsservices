package com.fourtk.productapi.controllers;

import com.fourtk.productapi.dtos.requesties.ProductRequest;
import com.fourtk.productapi.dtos.responses.ProductResponse;
import com.fourtk.productapi.services.impl.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductRequest> save(@Valid @RequestBody ProductRequest request) {
        request = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> users = service.getAllProducts();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductResponse>> getByCategoryId(@PathVariable Long id){
        List<ProductResponse> productsByCategoryId = service.getProductsByCategoryId(id);
        return ResponseEntity.ok().body(productsByCategoryId);
    }

    @GetMapping("/identify/{productIdentifier}")
    public ResponseEntity<ProductResponse> findByProductIdentifier(@PathVariable String productIdentifier){
        ProductResponse response = service.findByProductByIdentifier(productIdentifier);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
