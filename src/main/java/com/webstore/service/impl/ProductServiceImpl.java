package com.webstore.service.impl;

import com.webstore.modal.dto.ProductDto;
import com.webstore.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    List<ProductDto> allProducts;

    @Override
    public List<ProductDto> getAllProducts() {
        return allProducts;
    }

    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        return allProducts.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsById(String category, String productId) {
        return allProducts.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category) &&
                        product.getProductId().equals(productId))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        allProducts = new ArrayList<>();
        ProductDto product1 = new ProductDto("p1", "smartphone", "Galaxy A", "Description of Galaxy A", "samsung", 50000);
        ProductDto product2 = new ProductDto("p2", "smartphone", "iPhone 11", "Description of iPhone 11", "apple", 80000);
        ProductDto product3 = new ProductDto("p3", "laptop", "inspiron 14", "Description of inspiron 14", "dell", 45000);

        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);

    }

}
