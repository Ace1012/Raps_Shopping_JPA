package com.rapsShopping.shopping.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rapsShopping.shopping.models.EList;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ListDTO {

    private Long id;
    private String name;
    private List<ItemDTO> items;

    public ListDTO(EList eList, List<ItemDTO> items) {
        this.id = eList.getId();
        this.name = eList.getShoppingMonth();
        this.items = items;
    }

    public ListDTO(Long id, List<ItemDTO> items) {
        this.id = id;
        this.items = items;
    }
}
