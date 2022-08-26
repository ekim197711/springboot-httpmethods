package com.example.springboothttpmethods.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;

@SpringBootTest
class SomeTryingTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    @DisplayName("Another test")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void anotherMessageTest() {
        MessageEntity mike = messageRepository.save(
                MessageEntity.builder()
                        .author("Mike")
                        .message("Hello this is a tst message")
                        .saveTime(LocalDateTime.now())
                        .build()
        );
        Assertions.assertNotNull(mike.id());
        System.out.println("SomeTrying test that will pollute the db with 1 message");
    }

    @Test
    @DisplayName("This tests that we can save a message")
    void myMessageTest() {
        Assertions.assertEquals(0, messageRepository.count());
        messageRepository.save(
                MessageEntity.builder()
                        .author("Mike")
                        .message("Hello this is a tst message")
                        .saveTime(LocalDateTime.now())
                        .build()
        );
        Assertions.assertEquals(1, messageRepository.count());
        System.out.println("SomeTrying test that will pollute the db with 1 message");
    }
}