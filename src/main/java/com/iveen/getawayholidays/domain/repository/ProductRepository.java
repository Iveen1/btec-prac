package com.iveen.getawayholidays.domain.repository;

import com.iveen.getawayholidays.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
