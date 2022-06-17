package com.rapsShopping.shopping.repositories;

import com.rapsShopping.shopping.models.EUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EUser, Long> {

    @Query("SELECT u FROM users u WHERE u.id = ?1")
    EUser fetchUserById(Long userId);

    @Query("SELECT u FROM users u WHERE u.username = ?1")
    EUser fetchUserByUsername(String username);

}
