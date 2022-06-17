package com.rapsShopping.shopping.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryItemsDTO {

    private Long id;
    private String name;
    private List<ItemDTO> items;

    public CategoryItemsDTO(CategoryDTO categoryDTO, List<ItemDTO> items) {
        this.id = categoryDTO.getId();
        this.name = categoryDTO.getName();
        this.items = items;
    }
}
