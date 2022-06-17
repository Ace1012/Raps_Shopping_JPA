package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.models.ECategory;
import com.rapsShopping.shopping.models.EItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ECategory, Long> {

    @Query("SELECT c FROM categories c WHERE c.id = ?1")
    ECategory fetchCategoryById(Long categoryId);

}
