package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.dtos.ListDTO;
import com.rapsShopping.shopping.models.EList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<EList, Long> {

    @Query("SELECT l FROM lists l WHERE l.id=?1")
    EList fetchListById(Long listId);

}
