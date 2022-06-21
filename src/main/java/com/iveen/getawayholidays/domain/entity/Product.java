package com.iveen.getawayholidays.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:20
 * @project getaway-holidays
 */

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EProduct type;

    @Column(nullable = false)
    private String title;

    private Double price;
}
