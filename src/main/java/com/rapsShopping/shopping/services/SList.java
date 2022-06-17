package com.rapsShopping.shopping.services;

import com.rapsShopping.shopping.dtos.CategoryDTO;
import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.dtos.ListDTO;
import com.rapsShopping.shopping.models.EItem;
import com.rapsShopping.shopping.models.EList;
import com.rapsShopping.shopping.models.EList_Items;
import com.rapsShopping.shopping.repositories.ListRepository;
import com.rapsShopping.shopping.repositories.List_ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SList {

    private final ListRepository listRepository;
    private final List_ItemsRepository listItemsRepository;
    private final SItem sItem;

    private List<EList_Items> list_items = null;
    private List<ItemDTO> items = null;

    @Autowired
    public SList(ListRepository listRepository, List_ItemsRepository listItemsRepository, SItem sItem) {
        this.listRepository = listRepository;
        this.listItemsRepository = listItemsRepository;
        this.sItem = sItem;
    }

    //Fetch All Lists
    public List<ListDTO> fetchLists(){

        list_items = listItemsRepository.findAll();
        items = sItem.getItems();
        List<EList> list = listRepository.findAll();

        return list.stream()
                .map(this::convertToDTO).toList();
    }

    //Fetch specific list
    public ListDTO fetchList(Long id) {

//        Long listId;
//
//        if(id.length() > 0){
//            listId = Long.valueOf(id);
//        }else{
//            throw new BadCredentialsException("Incorrect ID!");
//        }

        return convertToDTO(listRepository.fetchListById(id));
    }

    public ListDTO convertToDTO(EList eList){

        List<ItemDTO> itemDTOS = new ArrayList<>();

        for(EList_Items list_item:list_items){
            if(eList.getId().equals(list_item.getEList().getId())){
                for(ItemDTO itemDTO:items){
                    if(list_item.getEItem().getId().equals(itemDTO.getId())){
                        itemDTOS.add(itemDTO);
                    }
                }
            }
        }


        return new ListDTO(eList, itemDTOS);
    }
}
