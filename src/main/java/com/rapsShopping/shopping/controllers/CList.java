package com.rapsShopping.shopping.controllers;

import com.rapsShopping.shopping.dtos.ItemDTO;
import com.rapsShopping.shopping.dtos.ListDTO;
import com.rapsShopping.shopping.models.EList_Items;
import com.rapsShopping.shopping.services.SList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "raps/lists")
public class CList {

    private final SList sList;

    @Autowired
    public CList(SList sList) {
        this.sList = sList;
    }

    @GetMapping(path = "/fetchLists")
    public List<ListDTO> fetchLists(){
        return sList.fetchLists();
    }

    @GetMapping(path = "/fetchList")
    public ListDTO fetchList(@RequestParam Long id){
        return sList.fetchList(id);
    }

    @PutMapping(path = "/editList")
    public ListDTO editList(@RequestBody ListDTO listDTO){
        return sList.editList(listDTO);
    }

}
