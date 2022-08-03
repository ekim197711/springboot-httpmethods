package com.example.springboothttpmethods.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageControllerTest {

    @Autowired
    MessageController messageController;

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
}