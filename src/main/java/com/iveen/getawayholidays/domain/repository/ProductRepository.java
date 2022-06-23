package com.iveen.getawayholidays.domain.repository;

import com.iveen.getawayholidays.domain.entity.EProduct;
import com.iveen.getawayholidays.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByType(EProduct type, Pageable pageable);
}
