package com.ecommerce.item.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="Item")
@Getter
@Entity
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String category;
    private String itemType;
    private String brand;
    private String model;
    private int quanitity;
    private float rating;
    private boolean active;
    private String discription;
    private float price;
    private String itemImage;
}