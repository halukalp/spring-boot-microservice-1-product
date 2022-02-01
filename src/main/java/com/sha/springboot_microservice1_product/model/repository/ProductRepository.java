package com.sha.springboot_microservice1_product.model.repository;

import com.sha.springboot_microservice1_product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Product findByPriceGreaterThan(Double upperLimit);

    Product findByPriceGreaterThanEqual(Double upperLimit);
}
