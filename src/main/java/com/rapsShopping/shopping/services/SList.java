package com.rapsShopping.shopping.services;

import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.dtos.ListDTO;
import com.rapsShopping.shopping.models.EList;
import com.rapsShopping.shopping.models.EList_Items;
import com.rapsShopping.shopping.repositories.ListRepository;
import com.rapsShopping.shopping.repositories.List_ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SList {

    private final ListRepository listRepository;
    private final List_ItemsRepository listItemsRepository;
    private final SItem sItem;

    private List<EList_Items> list_items;
    private List<ItemDTO> items;

    @Value("${default.value.status.deleted}")
    Long deletedDefault;

    @Autowired
    public SList(ListRepository listRepository, List_ItemsRepository listItemsRepository, SItem sItem) {
        this.listRepository = listRepository;
        this.listItemsRepository = listItemsRepository;
        this.sItem = sItem;
        list_items = listItemsRepository.findAll();
        items = sItem.getItems();
    }

    //Fetch All Lists
    public List<ListDTO> fetchLists(){
        List<EList> list = listRepository.findAll();

        return list.stream()
                .map(this::convertListToDTO).toList();
    }

    //Fetch specific list
    public ListDTO fetchList(Long id) {
        return convertListToDTO(listRepository.fetchListById(id));
    }

    //Update list items(adding items, removing items and/or updating quantities)
    public ListDTO editList(ListDTO listDTO) {
        List<EList_Items> storedListItems = listItemsRepository.fetchListItemsById(listDTO.getId());
        List<ItemDTO> items = listDTO.getItems();
        boolean itemFound = false;
        System.out.println("DB size is " + storedListItems.size() + " and sent size is " + items.size());
        
        if(items.size() < storedListItems.size()){
            System.out.println("Sent less items!!!");
            List<EList_Items> itemsToDelete = new ArrayList<>();


            for(EList_Items listItem:storedListItems){
                for(ItemDTO itemDTO:items){
                    if(itemDTO.getId().equals(listItem.getEItem().getId())){
                        itemFound = true;
                        break;
                    }
                }
                if(!itemFound){
                    itemsToDelete.add(listItem);
                }
                itemFound = false;
            }
            deleteListItems(itemsToDelete);
            storedListItems = listItemsRepository.fetchListItemsById(listDTO.getId());

        } else if (items.size() > storedListItems.size()) {
            System.out.println("Sent more items!!!");
            for(ItemDTO itemDTO: items){
                for(EList_Items listItem: storedListItems){
                    if(listItem.getEItem().getId().equals(itemDTO.getId())){
                        itemFound = true;
                        System.out.println("previous quantity is " + listItem.getQuantity());
                        System.out.println("New quantity is " + itemDTO.getQuantity());
                        listItem.setQuantity(itemDTO.getQuantity());
                        break;
                    }
                }
                if(!itemFound){
                    EList_Items listItem = convertToEListItem(listDTO, itemDTO);
                    System.out.println("New item is: " + listItem + "\n");
                    storedListItems.add(listItem);
                }
            }
        }else{
            for(ItemDTO itemDTO: items){
                for(EList_Items listItem: storedListItems){
                    if(listItem.getEItem().getId().equals(itemDTO.getId())){
                        System.out.println("previous quantity is " + listItem.getQuantity());
                        System.out.println("New quantity is " + itemDTO.getQuantity());
                        listItem.setQuantity(itemDTO.getQuantity());
                    }
                }
            }
        }

        listItemsRepository.saveAll(storedListItems);
        list_items = listItemsRepository.findAll();
        return convertListToDTO(listRepository.fetchListById(listDTO.getId()));
    }
    
    private void deleteListItems(List<EList_Items> list_items){
        System.out.println("Deleting " + list_items.size() + " items!!!");
        System.out.println(list_items);
        listItemsRepository.deleteAll(list_items);
    }

    private EList_Items convertToEListItem(ListDTO listDTO ,ItemDTO itemDTO){
        EList_Items listItem = new EList_Items();
        listItem.setEList(listRepository.fetchListById(listDTO.getId()));
        listItem.setEItem(sItem.getEItem(itemDTO.getId()));
        listItem.setQuantity(itemDTO.getQuantity());
        return listItem;
    }
    public ListDTO convertListToDTO(EList eList){

        List<ItemDTO> itemDTOS = new ArrayList<>();

        for(EList_Items list_item:list_items){
            if(eList.getId().equals(list_item.getEList().getId())){
                for(ItemDTO itemDTO:items){
                    if(list_item.getEItem().getId().equals(itemDTO.getId())){
                        System.out.println(list_item.getQuantity());
                        itemDTOS.add(new ItemDTO(itemDTO, list_item.getQuantity()));
                    }
                }
            }
        }
        return new ListDTO(eList, itemDTOS);
    }
}
