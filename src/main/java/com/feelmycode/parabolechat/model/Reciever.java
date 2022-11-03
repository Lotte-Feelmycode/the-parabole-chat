package com.feelmycode.parabolechat.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
public class Reciever {

    @Id
    private Long userId;
    private String name;

    public Reciever(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
