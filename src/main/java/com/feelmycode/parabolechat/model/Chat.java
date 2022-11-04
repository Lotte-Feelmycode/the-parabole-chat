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
    // TODO: 이벤트 방번호로 변경
    private String roomNumber;
    private String chatTitle;
    private Boolean isEvent;
    private Long sellerId;
    private LocalDateTime createdAt;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setIsSeller(Boolean seller) {
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
        Boolean isSeller, Boolean isSecret, String roomNumber, String chatTitle, Boolean isEvent,
        Long sellerId, LocalDateTime createdAt) {
        this.id = id;
        this.msg = msg;
        this.coupon = coupon;
        this.product = product;
        this.sender = sender;
        this.receiver = receiver;
        this.isSeller = isSeller;
        this.isSecret = isSecret;
        this.roomNumber = roomNumber;
        this.chatTitle = chatTitle;
        this.isEvent = isEvent;
        this.sellerId = sellerId;
        this.createdAt = createdAt;
    }
}
