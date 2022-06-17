package com.rapsShopping.shopping.controllers;

import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.models.EItem;
import com.rapsShopping.shopping.services.SItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/raps/items")
public class CItem {

    private final SItem sItem;

    @Autowired
    public CItem(SItem sItem) {
        super();
        this.sItem = sItem;
    }

    @GetMapping(path = "/fetchItems")
    public List<ItemDTO> getItems(){
        return sItem.getItems();
    }
}
