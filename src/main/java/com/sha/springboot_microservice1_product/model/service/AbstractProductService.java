package com.sha.springboot_microservice1_product.model.service;

import com.sha.springboot_microservice1_product.model.entity.Product;
import com.sha.springboot_microservice1_product.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractProductService implements EntityService<Product, Integer>
{
    @Autowired
    protected ProductRepository productRepository;

    protected abstract Product findByPriceGreaterThanEqual(Double upperLimit);

    protected abstract Product findByPriceGreaterThan(Double upperLimit);
}
