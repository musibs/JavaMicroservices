package com.springbytes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Products")
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private String summary;
    private String description;
    private String imageFile;
    private String price;
}
