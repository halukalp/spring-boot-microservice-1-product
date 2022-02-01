package com.sha.springboot_microservice1_product.controller;

import com.sha.springboot_microservice1_product.model.entity.Product;
import com.sha.springboot_microservice1_product.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// pre-path (Req. mapping, altındaki tüm metotları etkiler.)
// get() icin de post() icin de ayni mapping'i kullanabiliriz.
// api/product'ı 2 farklı get() metodu için kullanırsak hata alırız.
@RestController
@RequestMapping("api/product")
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

    // -> api/product
    @GetMapping
    public ResponseEntity<?> getAllProducts()
    {
        List<Product> productList = productService.findAll();
        return ResponseEntity.ok(productList); // cevabın döndürülmesi
    }

    @DeleteMapping("{productId}") // api/product/productID
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer productID)
    {
        productService.delete(productID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping // -> api/product
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
