package com.iveen.getawayholidays.pojo.order;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 22:32
 * @project getaway-holidays
 */

@Data
public class ProductRequest {
    @NotNull
    private Long productId;

    @NotNull
    private int amount;
}
