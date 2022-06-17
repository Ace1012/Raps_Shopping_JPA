package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.models.EItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<EItem, Long> {

    @Query("SELECT i FROM items i WHERE i.id = ?1")
    EItem fetchItemById(Long itemId);

}
