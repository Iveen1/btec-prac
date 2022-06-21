package com.iveen.getawayholidays.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iveen.getawayholidays.domain.entity.Product;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:57
 * @project getaway-holidays
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;

    @NotNull
    @JsonProperty("FCS")
    private String FCS;

    @NotNull
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NotNull
    @JsonProperty("products")
    private List<OrderDetailsDto> orderDetails;
}
