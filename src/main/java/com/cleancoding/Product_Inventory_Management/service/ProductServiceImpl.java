package com.cleancoding.Product_Inventory_Management.service;

import com.cleancoding.Product_Inventory_Management.entities.Product;
import com.cleancoding.Product_Inventory_Management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(product -> {
            if (updatedProduct.getName() != null) product.setName(updatedProduct.getName());
            if (updatedProduct.getDescription() != null) product.setDescription(updatedProduct.getDescription());
            if (updatedProduct.getPrice() != 0) product.setPrice(updatedProduct.getPrice());
            if (updatedProduct.getQuantity() != 0) product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        });
    }
}

