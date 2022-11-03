package com.feelmycode.parabolechat.model;

import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private String imageUrl;

    public Product(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
