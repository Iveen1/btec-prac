package com.iveen.getawayholidays.domain.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 19:17
 * @project getaway-holidays
 */

@Entity
@Getter
@Setter
@Builder
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;

    private Double price;
}
