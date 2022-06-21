package com.iveen.getawayholidays.service;

import com.iveen.getawayholidays.dto.ProductDto;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductDto create(ProductDto productDto);

    ProductDto update(Long id, ProductDto productDto);

    ProductDto findById(Long id);

    void delete(Long id);

    Page<ProductDto> findAll(int page, int size);
}
