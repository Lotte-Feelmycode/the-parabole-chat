package com.feelmycode.parabolechat.model;

import lombok.Getter;

@Getter
public class Coupon {

    private Long id;
    private String name;

    public Coupon(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
