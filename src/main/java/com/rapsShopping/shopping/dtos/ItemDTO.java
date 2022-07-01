package com.rapsShopping.shopping.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rapsShopping.shopping.models.EItem;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Optional;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {

    private Long id;
    private String name;
    private String stock;
    private Long price;
    private CategoryDTO category;
    private Long quantity;

    public ItemDTO(EItem eItem, CategoryDTO categoryDTO) {
        this.id = eItem.getId();
        this.name = eItem.getName();
        this.stock = eItem.getStock();
        this.price = eItem.getPrice();
        this.category = categoryDTO;
    }

    public ItemDTO(ItemDTO itemDTO, Long quantity) {
        this.id = itemDTO.getId();
        this.name = itemDTO.getName();
        this.stock = itemDTO.getStock();
        this.price = itemDTO.getPrice();
        this.category = itemDTO.getCategory();
        this.quantity = quantity;
    }
}
