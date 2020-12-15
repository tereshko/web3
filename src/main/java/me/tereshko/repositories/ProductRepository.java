package me.tereshko.repositories;

import me.tereshko.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1L, "Idea", 6.66));
        productList.add(new Product(2L, "Safari", 2.99));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getProductById(int productId) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void deleteProductById(Long id) {
        productList.removeIf(b -> b.getId().equals(id));
    }

}
