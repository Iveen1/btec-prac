package com.iveen.getawayholidays.service.impl;

import com.iveen.getawayholidays.domain.entity.Product;
import com.iveen.getawayholidays.domain.mapper.ProductMapper;
import com.iveen.getawayholidays.domain.repository.ProductRepository;
import com.iveen.getawayholidays.dto.ProductDto;
import com.iveen.getawayholidays.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:54
 * @project getaway-holidays
 */

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto create(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found!"));
        productMapper.update(productDto, product);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found!")));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductDto> findAll(int page, int size) {
        Page<Product> entityPage = productRepository.findAll(PageRequest.of(page, size));

        return new PageImpl<>(
                productMapper.toDto(entityPage.toList()),
                PageRequest.of(page, size),
                entityPage.getTotalElements()
        );
    }
}
