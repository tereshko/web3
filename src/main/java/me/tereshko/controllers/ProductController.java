package me.tereshko.controllers;

import me.tereshko.model.Product;
import me.tereshko.services.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/")
    public String getAllBoxes(Model model) {
        model.addAttribute("products", productServices.getAllProducts());
        return "all_products";
    }

    @GetMapping("/remove/{id}")
    public String removeProductById(@PathVariable Long id) {
        productServices.deleteProductById(id);
        return "redirect:/products/";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam Long id, @RequestParam String name, @RequestParam double price) {
        Product product = new Product(id, name, price);
        productServices.saveProduct(product);
        return "redirect:/products/";
    }

}
