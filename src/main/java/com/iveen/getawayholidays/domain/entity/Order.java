package com.iveen.getawayholidays.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Polyakov Anton
 * @created 21.06.2022 17:25
 * @project getaway-holidays
 */

@Entity
@Getter
@Setter
@Builder
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderDetails> orderDetails;

    @Column(nullable = false)
    private String FCS;

    @Column(nullable = false)
    private String phoneNumber;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDetails=" + orderDetails +
                ", FCS='" + FCS + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
