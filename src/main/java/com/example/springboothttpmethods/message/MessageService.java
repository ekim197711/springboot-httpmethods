package com.example.springboothttpmethods.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public RestResponseNewMessage createNew(RestRequestNewMessage restRequestNewMessage) {
        MessageEntity newEntity = MessageEntity
                .builder()
                .message(restRequestNewMessage.getMessage())
                .saveTime(LocalDateTime.now())
                .build();
        MessageEntity save = messageRepository.save(newEntity);
        return RestResponseNewMessage.fromEntity(save);
    }
}
