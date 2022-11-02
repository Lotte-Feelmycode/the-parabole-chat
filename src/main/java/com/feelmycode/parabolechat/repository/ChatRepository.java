package com.feelmycode.parabolechat.repository;

import com.feelmycode.parabolechat.model.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

    @Tailable
    Flux<Chat> findChatsBySenderAndReceiver(String sender, String receiver);

    @Tailable
    Flux<Chat> findChatsByRoomNumber(String roomNumber);
}
