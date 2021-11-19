package com.springbytes.controller;

import com.springbytes.model.Product;
import com.springbytes.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/catalog")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductsById(@PathVariable("id") String id) {
        return productRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Collection<Product> getProductsByName(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }

    @GetMapping("/category/{category}")
    public Collection<Product> getProductsByCategory(@PathVariable("category") String category) {
        return productRepository.findByCategory(category);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        if(productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        }
        throw new RuntimeException("Associated product with product id "+product.getId() +" does not exists");
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
        throw new RuntimeException("Associated product with product id "+ id +" does not exists");
    }

    @DeleteMapping
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
