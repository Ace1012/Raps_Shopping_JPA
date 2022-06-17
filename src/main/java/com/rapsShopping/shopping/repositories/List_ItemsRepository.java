package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.models.EList_Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface List_ItemsRepository extends JpaRepository<EList_Items, Long> {
}
