package com.rapsShopping.shopping.services;

import com.rapsShopping.shopping.dtos.CategoryDTO;
import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.models.ECategory;
import com.rapsShopping.shopping.models.EItem;
import com.rapsShopping.shopping.repositories.CategoryRepository;
import com.rapsShopping.shopping.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SItem {

    private final ItemRepository itemRepository;
    private final List<CategoryDTO> categories;

    @Autowired
    public SItem(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        categories = categoryRepository.findAll().stream().map(this::convertCategoryToDTO).toList();
    }

    //GET items
    public List<ItemDTO> getItems(){
        return itemRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public EItem getEItem(Long id){
        return itemRepository.fetchItemById(id);
    }

    private CategoryDTO convertCategoryToDTO(ECategory eCategory){
        return new CategoryDTO(eCategory);
    }

    public ItemDTO convertToDTO(EItem eItem){

        ItemDTO itemDTO = null;

        for(CategoryDTO categoryDTO: categories){
            if(eItem.getCategory().equals(categoryDTO.getId())){
                itemDTO = new ItemDTO(eItem, categoryDTO);
            }
        }
        return itemDTO;
    }

}
