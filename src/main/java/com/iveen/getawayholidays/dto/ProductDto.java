package com.iveen.getawayholidays.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iveen.getawayholidays.domain.entity.EProduct;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:57
 * @project getaway-holidays
 */

@Getter
@Setter
public class ProductDto {
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("type")
    private EProduct type;

    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("price")
    private Double price;
}
