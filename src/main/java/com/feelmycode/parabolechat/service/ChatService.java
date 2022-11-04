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


    // event or seller 방 번호로 계속해서 조회
    public Flux<Chat> getMessagesByRoomNumber(String roomNumber) {
        return chatRepository.findChatsByRoomNumber(roomNumber);
    }

    // 일대일 문의
    public Flux<Chat> getMessagesBySenderAndReceiver(String sender, String receiver) {
        return chatRepository.findChatsBySenderAndReceiver(sender, receiver);
    }

    // 메시지 보내기
    public Mono<Chat> sendMessage(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    // 메시지 보내기 (이벤트/셀러문의 분리)
    public Mono<Chat> sendMessage(Chat chat, Boolean isSeller, Boolean isEvent) {
        chat.setIsSeller(isSeller);
        chat.setEvent(isEvent);
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    // 채팅방 입장
    public Mono<Chat> sendEnterMessage(Chat chat, Boolean isEvent) {
        chat.setMsg(chat.getSender().getName() + "님이 입장하셨습니다."); // => 이건 프론트에서 ?
        chat.setEvent(isEvent);
        chat.setCreatedAt(LocalDateTime.now());

        return chatRepository.save(chat);
    }

    public Flux<Chat> getChatList(Long sellerId) {
        Flux<Chat> chatFlux = chatRepository.findChatsBySellerIdOrderByCreatedAtDesc(sellerId);
    }
}
