package com.feelmycode.parabolechat.service;

import com.feelmycode.parabolechat.model.Chat;
import com.feelmycode.parabolechat.repository.ChatRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;


    public Flux<Chat> getMessagesByRoomNumber(String roomNumber) {
        return chatRepository.findChatsByRoomNumber(roomNumber);
    }

    public Flux<Chat> getMessagesBySenderAndReceiver(String sender, String receiver) {
        return chatRepository.findChatsBySenderAndReceiver(sender, receiver);
    }

    public Mono<Chat> sendMessage(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    public Mono<Chat> sendMessage(Chat chat, Boolean isSeller, Boolean isEvent) {
        chat.setSeller(isSeller);
        chat.setEvent(isEvent);
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }

}
