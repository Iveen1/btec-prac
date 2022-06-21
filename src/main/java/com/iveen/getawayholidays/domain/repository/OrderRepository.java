package com.iveen.getawayholidays.domain.repository;

import com.iveen.getawayholidays.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
