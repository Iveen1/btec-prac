package com.iveen.getawayholidays.service;

import com.iveen.getawayholidays.dto.OrderDto;
import com.iveen.getawayholidays.pojo.order.OrderRequest;
import org.springframework.data.domain.Page;

public interface OrderService {
    OrderDto create(OrderRequest orderRequest);

    OrderDto update(Long id, OrderDto orderDto);

    OrderDto findById(Long id);

    void delete(Long id);

    Page<OrderDto> findAll(int page, int size);
}
