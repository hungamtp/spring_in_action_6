package com.example.chapter4.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Document("taco")
public class Taco {

    @PrimaryKeyJoinColumn
    private String id;

    private String name;
    private int quantity;
    private String category;
}