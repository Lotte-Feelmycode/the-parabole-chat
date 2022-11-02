package com.feelmycode.parabolechat.model;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "chat")
public class Chat {

    @Id
    private String id;
    private String msg;
    // private Coupon coupon;
    // private Product product;
    private String sender;
    private String receiver;
    private Boolean isSeller;
    private Boolean isSecret;
    private String roomNumber;
    private Boolean isEvent;
    private LocalDateTime createdAt;

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }

    public void setEvent(Boolean event) {
        isEvent = event;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Chat(String id, String msg, String sender, String receiver, Boolean isSeller,
        Boolean isSecret, String roomNumber, LocalDateTime createdAt) {
        this.id = id;
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.isSeller = isSeller;
        this.isSecret = isSecret;
        this.roomNumber = roomNumber;
        this.createdAt = createdAt;
    }
}
