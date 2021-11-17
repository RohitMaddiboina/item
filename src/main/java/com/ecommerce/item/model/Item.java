package com.ecommerce.item.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Setter
    private int quanitity;
    private float rating;
    private boolean active;
    private String discription;
    private float price;
    private String itemImage;
    @Setter 
    @Column(length = 16777215, columnDefinition = "LONGBLOB" ) 
    private byte[] primaryImage;
}