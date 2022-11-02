package com.feelmycode.parabolechat.controller;

import com.feelmycode.parabolechat.model.Chat;
import com.feelmycode.parabolechat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    @Autowired
    ChatService chatService;

    @CrossOrigin
    @GetMapping(value = "/sender/{sender}/receiver/{receiver}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMessagesBySenderAndReceiver(@PathVariable String sender, @PathVariable String receiver) {
        log.info("sender: {}, receiver: {}", sender, receiver);
        return chatService.getMessagesBySenderAndReceiver(sender, receiver)
            .subscribeOn(Schedulers.boundedElastic());
    }

    @CrossOrigin
    @GetMapping(value = "/roomnumber/{roomNumber}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Chat> getMessagesByRoomNumber(@PathVariable String roomNumber) {
        log.info("roomNumber: {}", roomNumber);
        return chatService.getMessagesByRoomNumber(roomNumber)
            .subscribeOn(Schedulers.boundedElastic());
    }

    @CrossOrigin
    @PostMapping("/event/seller")
    public Mono<Chat> sendMessageFromSellerAtEvent(@RequestBody Chat chat){
        return chatService.sendMessage(chat, true, true);
    }

    @CrossOrigin
    @PostMapping("/event/user")
    public Mono<Chat> sendMessageFromUserAtEvent(@RequestBody Chat chat){
        return chatService.sendMessage(chat, false, true);
    }


    @CrossOrigin
    @PostMapping()
    public Mono<Chat> sendMessage(@RequestBody Chat chat){
        return chatService.sendMessage(chat);
    }
}
