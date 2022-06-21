package com.iveen.getawayholidays.controller;

import com.iveen.getawayholidays.dto.ProductDto;
import com.iveen.getawayholidays.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:53
 * @project getaway-holidays
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public Page<ProductDto> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto) {
        ProductDto product = productService.create(productDto);
        return ResponseEntity.ok(Collections.singletonMap("response", "success create product " + product.getId()));
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok(Collections.singletonMap("response", "success delete product " + id));
    }
}
