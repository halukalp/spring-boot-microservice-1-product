package com.sha.springboot_microservice1_product.model.service;

import java.util.List;

public interface EntityService<E, I>
{
    List<E> findAll();

    public E save(E entity);

    public void delete(I id);
}
