package com.giftabled.springbootwithjpql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doorId;
    private String doorType;
    private String material;
    private String color;
    private double price;
}
