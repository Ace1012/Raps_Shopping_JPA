package com.rapsShopping.shopping.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity(name = "lists")
public class EList {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shopping_month")
    private String shoppingMonth;

    @Column(name = "list_date")
    private Timestamp listDate;

}
