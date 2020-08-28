package com.webstore.service;

import com.webstore.modal.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();
    List<ProductDto> getProductsByCategory(String category);
    List<ProductDto> getProductsById(String category, String productId);

}
