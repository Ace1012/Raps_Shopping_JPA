package com.rapsShopping.shopping.controllers;

import com.rapsShopping.shopping.dtos.CategoryDTO;
import com.rapsShopping.shopping.dtos.CategoryItemsDTO;
import com.rapsShopping.shopping.models.ECategory;
import com.rapsShopping.shopping.services.SCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/raps/categories")
public class CCategory {

    private final SCategory sCategory;

    @Autowired
    public CCategory(SCategory sCategory) {
        super();
        this.sCategory = sCategory;
    }

    @GetMapping(path = "/fetchCategories")
    public List<CategoryDTO> fetchCategories(){
        return sCategory.getCategories();
    }

    @GetMapping(path = "/fetchCategoryItems")
    public List<CategoryItemsDTO> fetchCategoryItems(){
        return sCategory.fetchCategoryItems();
    }

}
