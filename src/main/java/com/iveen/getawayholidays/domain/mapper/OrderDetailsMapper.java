package com.iveen.getawayholidays.domain.mapper;

import com.iveen.getawayholidays.domain.entity.OrderDetails;
import com.iveen.getawayholidays.dto.OrderDetailsDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {
    // to dto
    OrderDetailsDto toDto(OrderDetails entity);
    List<OrderDetailsDto> toDto(List<OrderDetails> entities);

    // to entity
    OrderDetails toEntity(OrderDetailsDto dto);
    List<OrderDetails> toEntities(List<OrderDetailsDto> dtos);

    void update(OrderDetailsDto dto, @MappingTarget OrderDetails orderDetails);
}
