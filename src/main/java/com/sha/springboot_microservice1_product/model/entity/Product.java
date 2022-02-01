package com.sha.springboot_microservice1_product.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product extends com.sha.springboot_microservice1_product.model.entity.Entity<Integer>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    @Override
    public Integer getId()
    {
        return super.getId();
    }

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;
}
