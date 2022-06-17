package com.rapsShopping.shopping.dtos;

import com.rapsShopping.shopping.models.EItem;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO {

    private Long id;
    private String name;
    private String stock;
    private Long price;
    private CategoryDTO category;

    public ItemDTO(EItem eItem, CategoryDTO categoryDTO) {
        this.id = eItem.getId();
        this.name = eItem.getName();
        this.stock = eItem.getStock();
        this.price = eItem.getPrice();
        this.category = categoryDTO;
    }
}
