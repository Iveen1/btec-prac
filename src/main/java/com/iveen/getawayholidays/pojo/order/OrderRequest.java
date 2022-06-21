package com.iveen.getawayholidays.pojo.order;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 19:52
 * @project getaway-holidays
 */

@Data
public class OrderRequest {
    @NotNull
    private String FCS;

    @NotNull
    private String phoneNumber;

    @NotNull
    private List<ProductRequest> products;

    @Override
    public String toString() {
        return "OrderRequest{" +
                "FCS='" + FCS + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", products=" + products +
                '}';
    }
}
