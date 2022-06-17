package com.rapsShopping.shopping.dtos;

import com.rapsShopping.shopping.models.ECategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(ECategory eCategory) {
        this.id = eCategory.getId();
        this.name = eCategory.getName();
    }
}
