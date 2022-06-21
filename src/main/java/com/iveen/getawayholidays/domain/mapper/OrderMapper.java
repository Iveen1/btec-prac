package com.iveen.getawayholidays.domain.mapper;

import com.iveen.getawayholidays.domain.entity.Order;
import com.iveen.getawayholidays.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    // to dto
    OrderDto toDto(Order entity);
    List<OrderDto> toDto(List<Order> entities);

    // to entity
    Order toEntity(OrderDto dto);
    List<Order> toEntities(List<OrderDto> dtos);

    void update(OrderDto dto, @MappingTarget Order order);
}
