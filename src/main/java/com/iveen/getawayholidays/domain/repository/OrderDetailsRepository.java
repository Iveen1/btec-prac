package com.iveen.getawayholidays.domain.repository;

import com.iveen.getawayholidays.domain.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
