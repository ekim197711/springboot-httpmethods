package com.example.springboothttpmethods.message;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public RestResponseNewMessage createNew(RestRequestNewMessage restRequestNewMessage) {
        MessageEntity newEntity = MessageEntity
                .builder()
                .message(restRequestNewMessage.getMessage())
                .author(restRequestNewMessage.getAuthor())
                .saveTime(LocalDateTime.now())
                .build();
        MessageEntity save = messageRepository.save(newEntity);
        return RestResponseNewMessage.fromEntity(save);
    }

    public RestResponseNewMessage updateMessage(Long messageId, RestRequestNewMessage restRequest) {
        Optional<MessageEntity> byId = messageRepository.findById(messageId);
        if (byId.isEmpty())
            throw new IllegalArgumentException("No message has been found with id: " + messageId);
        MessageEntity message = byId.get();
        MessageEntity saved = messageRepository.save(
                message
                        .message(restRequest.getMessage() == null ? message.message() : restRequest.getMessage())
                        .author(restRequest.getAuthor() == null ? message.author() : restRequest.getAuthor())
        );
        return RestResponseNewMessage.fromEntity(saved);
    }
}
