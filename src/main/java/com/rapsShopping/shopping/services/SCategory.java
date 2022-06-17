package com.rapsShopping.shopping.services;

import com.rapsShopping.shopping.dtos.CategoryDTO;
import com.rapsShopping.shopping.dtos.CategoryItemsDTO;
import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.models.ECategory;
import com.rapsShopping.shopping.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SCategory {

    private final CategoryRepository categoryRepository;
    private final SItem sItem;
    private List<ItemDTO> items;

    @Autowired
    public SCategory(CategoryRepository categoryRepository, SItem sItem) {
        this.categoryRepository = categoryRepository;
        this.sItem = sItem;
    }

    //Get all categories
    public List<CategoryDTO> getCategories(){
        return categoryRepository.findAll()
                .stream()
                .map(this::convertCategoryToDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryItemsDTO> fetchCategoryItems() {

        items = sItem.getItems();
        List<CategoryDTO> categoryDTOS = getCategories();

        return categoryDTOS.stream().map(this::convertToCategoryItemsDTO).toList();
    }

    private CategoryDTO convertCategoryToDTO(ECategory eCategory){
        return new CategoryDTO(eCategory);
    }

    private CategoryItemsDTO convertToCategoryItemsDTO(CategoryDTO categoryDTO){

        List<ItemDTO> categoryItems = new ArrayList<>();

        for(ItemDTO itemDTO: items){
            if(itemDTO.getCategory().getId().equals(categoryDTO.getId())){
                categoryItems.add(itemDTO);
            }
        }

        return new CategoryItemsDTO(categoryDTO, categoryItems);
    }
}
