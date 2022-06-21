package com.iveen.getawayholidays.domain.mapper;

import com.iveen.getawayholidays.domain.entity.Product;
import com.iveen.getawayholidays.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    // to dto
    ProductDto toDto(Product entity);
    List<ProductDto> toDto(List<Product> entities);

    // to entity
    Product toEntity(ProductDto dto);
    List<Product> toEntities(List<ProductDto> dtos);

    void update(ProductDto dto, @MappingTarget Product product);
}
