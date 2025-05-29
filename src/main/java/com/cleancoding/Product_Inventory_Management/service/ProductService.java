package com.cleancoding.Product_Inventory_Management.service;

import com.cleancoding.Product_Inventory_Management.entities.Product;

import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);
    Optional<Product> getProduct(Long id);
    Optional<Product> updateProduct(Long id, Product updatedProduct);
}
