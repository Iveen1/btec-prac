package com.iveen.getawayholidays.service.impl;

import com.iveen.getawayholidays.domain.entity.Order;
import com.iveen.getawayholidays.domain.entity.OrderDetails;
import com.iveen.getawayholidays.domain.entity.Product;
import com.iveen.getawayholidays.domain.mapper.OrderMapper;
import com.iveen.getawayholidays.domain.repository.OrderRepository;
import com.iveen.getawayholidays.domain.repository.ProductRepository;
import com.iveen.getawayholidays.dto.OrderDto;
import com.iveen.getawayholidays.pojo.order.OrderRequest;
import com.iveen.getawayholidays.pojo.order.ProductRequest;
import com.iveen.getawayholidays.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:53
 * @project getaway-holidays
 */

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDto create(OrderRequest orderRequest) {
        List<OrderDetails> products = new ArrayList<>();
        for (ProductRequest item : orderRequest.getProducts()) {
            Optional<Product> byId = productRepository.findById(item.getProductId());

            OrderDetails orderDetails = OrderDetails.builder()
                            .product(byId.get())
                            .price(byId.get().getPrice())
                            .amount(item.getAmount())
                            .build();
            products.add(orderDetails);
        }
        Order order = Order.builder()
                        .FCS(orderRequest.getFCS())
                        .phoneNumber(orderRequest.getPhoneNumber())
                        .orderDetails(products)
                        .build();
        System.out.println(products.stream().map(item -> item.toString()).collect(Collectors.toList()));
        System.out.println(order.toString());
        System.out.println();
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDto update(Long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id " + id + " not found!"));
        orderMapper.update(orderDto, order);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public OrderDto findById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id " + id + " not found!")));
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Page<OrderDto> findAll(int page, int size) {
        Page<Order> entityPage = orderRepository.findAll(PageRequest.of(page, size));

        return new PageImpl<>(
                orderMapper.toDto(entityPage.toList()),
                PageRequest.of(page, size),
                entityPage.getTotalElements()
        );
    }
}
