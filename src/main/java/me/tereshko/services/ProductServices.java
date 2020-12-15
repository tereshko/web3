package me.tereshko.services;

import me.tereshko.model.Product;
import me.tereshko.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServices {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getProductList();
    }

    public void saveProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

}
