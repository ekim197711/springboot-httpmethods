package com.example.springboothttpmethods.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MessageControllerTest {

    @Autowired
    MessageController messageController;

    @Autowired
    MessageRepository messageRepository;

    @Test
    void newMessage() {
        final String SOME_MESSAGE = "Hello this is a message";
        RestResponseNewMessage response = messageController.newMessage(RestRequestNewMessage.builder()
                .message(SOME_MESSAGE)
                .build());

        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.getId());
        Assertions.assertNotNull(response.getMessage());
        Assertions.assertEquals(SOME_MESSAGE, response.getMessage());
        System.out.println(response);
    }

    @Test
    void updateMessage() {
        RestResponseNewMessage mike = messageController.newMessage(
                RestRequestNewMessage.builder()
                        .message("Roses are red violet are blue - Spring Boot I love you.")
                        .author("Mike")
                        .build()
        );
        final String MESSAGE_UPDATE = "once upon a time...";
        final String AUTHOR_UPDATE = "Jane";

        RestResponseNewMessage jane = messageController.updateMessage(mike.getId(),
                RestRequestNewMessage.builder()
                        .message(MESSAGE_UPDATE)
                        .author(AUTHOR_UPDATE)
                        .build()
        );

        Optional<MessageEntity> byId = messageRepository.findById(mike.getId());
        Assertions.assertTrue(byId.isPresent());
        System.out.println(byId.get());
        Assertions.assertNotNull(byId.get().id());
        Assertions.assertNotNull(byId.get().message());
        Assertions.assertNotNull(byId.get().author());
        Assertions.assertNotNull(byId.get().saveTime());
        Assertions.assertEquals(AUTHOR_UPDATE, byId.get().author());
        Assertions.assertEquals(MESSAGE_UPDATE, byId.get().message());

    }

    @Test
    void updateMessageWithNullAuthor() {
        RestResponseNewMessage mike = messageController.newMessage(
                RestRequestNewMessage.builder()
                        .message("Roses are red violet are blue - Spring Boot I love you.")
                        .author("Mike")
                        .build()
        );
        final String MESSAGE_UPDATE = "once upon a time...";
        final String AUTHOR_UPDATE = "Jane";

        RestResponseNewMessage jane = messageController.updateMessage(mike.getId(),
                RestRequestNewMessage.builder()
                        .message(MESSAGE_UPDATE)
                        .build()
        );

        Optional<MessageEntity> byId = messageRepository.findById(mike.getId());
        Assertions.assertTrue(byId.isPresent());
        System.out.println(byId.get());
        Assertions.assertNotNull(byId.get().id());
        Assertions.assertNotNull(byId.get().message());
        Assertions.assertNotNull(byId.get().author());
        Assertions.assertNotNull(byId.get().saveTime());
        Assertions.assertEquals(mike.getAuthor(), byId.get().author());
        Assertions.assertEquals(MESSAGE_UPDATE, byId.get().message());

    }
}