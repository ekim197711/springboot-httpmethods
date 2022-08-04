package com.example.springboothttpmethods.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestResponseNewMessage {

    private Long id;
    private String message;
    private String author;
    private LocalDateTime saveTime;
    private LocalDateTime responseDateTime;

    public static RestResponseNewMessage fromEntity(MessageEntity entity) {
        return RestResponseNewMessage.builder()
                .message(entity.message())
                .responseDateTime(LocalDateTime.now())
                .saveTime(entity.saveTime())
                .author(entity.author())
                .id(entity.id())
                .build();
    }
}
