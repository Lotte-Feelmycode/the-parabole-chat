package com.feelmycode.parabolechat.model;

import java.time.LocalDateTime;
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
    private Coupon coupon;  // 쿠폰 id, 쿠폰 이름, 재고
    private Product product;    // 상품 id, 상품명, 상품 image
    private Sender sender;
    private Reciever receiver;
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

    public Chat(String id, String msg, Coupon coupon, Product product, Sender sender,
        Reciever receiver,
        Boolean isSeller, Boolean isSecret, String roomNumber, Boolean isEvent,
        LocalDateTime createdAt) {
        this.id = id;
        this.msg = msg;
        this.coupon = coupon;
        this.product = product;
        this.sender = sender;
        this.receiver = receiver;
        this.isSeller = isSeller;
        this.isSecret = isSecret;
        this.roomNumber = roomNumber;
        this.isEvent = isEvent;
        this.createdAt = createdAt;
    }
}
