package com.iveen.getawayholidays.dto;

import com.iveen.getawayholidays.domain.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 19:23
 * @project getaway-holidays
 */

@Getter
@Setter
public class OrderDetailsDto {
    private Long id;

    @NotNull
    private Product product;

    @NotNull
    private int amount;

    @NotNull
    private Double price;
}
