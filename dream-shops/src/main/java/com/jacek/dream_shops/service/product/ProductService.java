package com.jacek.dream_shops.service.product;

import com.jacek.dream_shops.exceptions.ProductNotFoundException;
import com.jacek.dream_shops.model.Product;
import com.jacek.dream_shops.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, ()->{
            throw new ProductNotFoundException("Product "+id+" not found!");
        });
    }

    @Override
    public void updateProduct(Product product, Long productId) {

    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product "+id+" not found!"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.countByBrandAndName(brand, name);
    }
}
