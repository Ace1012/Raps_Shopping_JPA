package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.models.EList_Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface List_ItemsRepository extends JpaRepository<EList_Items, Long> {
    @Query("SELECT li FROM lists_items li WHERE li.eList.id=?1")
    List<EList_Items> fetchListItemsById(Long listId);
}
