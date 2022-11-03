package com.feelmycode.parabolechat.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;


@Getter
public class Sender {

    @Id
    private Long userId;
    private String name;

    public Sender(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}
