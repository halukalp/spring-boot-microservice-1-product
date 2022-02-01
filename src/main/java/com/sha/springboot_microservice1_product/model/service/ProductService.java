package com.sha.springboot_microservice1_product.model.service;

import com.sha.springboot_microservice1_product.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService extends AbstractProductService
{
    @Override
    protected Product findByPriceGreaterThanEqual(Double upperLimit)
    {
        return productRepository.findByPriceGreaterThan(upperLimit);
    }

    @Override
    protected Product findByPriceGreaterThan(Double upperLimit)
    {
        return productRepository.findByPriceGreaterThan(upperLimit);
    }

    @Override
    public List<Product> findAll()
    {
        return  productRepository.findAll();
    }

    @Override
    public void delete(Integer id)
    {
        productRepository.deleteById(id);
    }

    @Override
    public Product save(Product product)
    {
        product.setCreated(new Date());
        return productRepository.save(product);
    }


}
