package com.jacek.dream_shops.service.product;

import com.jacek.dream_shops.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void deleteProductById(Long id);
    void updateProduct(Product product, Long productId);

    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByName(String name);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByBrandAndName(String brand, String name);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    Long countProductsByBrandAndName(String brand, String name);

}
