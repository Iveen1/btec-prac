package com.iveen.getawayholidays.controller;

import com.iveen.getawayholidays.dto.OrderDto;
import com.iveen.getawayholidays.pojo.order.OrderRequest;
import com.iveen.getawayholidays.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:52
 * @project getaway-holidays
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("")
    public Page<OrderDto> getOrders(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return orderService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return orderService.findById(id);
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> addProduct(@Valid @RequestBody OrderDto orderDto) {
//        OrderDto order = orderService.create(orderDto);
//        return ResponseEntity.ok(Collections.singletonMap("response", "success create order " + order.getId()));
//    }
    @PostMapping("/create")
    @Transactional
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.create(orderRequest);
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<?> removeProduct(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok(Collections.singletonMap("response", "success delete order " + id));
    }
}
