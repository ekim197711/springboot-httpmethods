package com.example.springboothttpmethods.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles("mytest")
class AnotherTryingTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    @DisplayName("Fourth test")
    void myMessageTest() {
        System.out.println("Fourth test expects no message in db");
        Assertions.assertEquals(4, messageRepository.count());
        messageRepository.save(
                MessageEntity.builder()
                        .author("Mike")
                        .message("Hello this is a tst message")
                        .saveTime(LocalDateTime.now())
                        .build()
        );
        Assertions.assertEquals(5, messageRepository.count());
        System.out.println("Fourth test expects no message in db - END");
    }
}