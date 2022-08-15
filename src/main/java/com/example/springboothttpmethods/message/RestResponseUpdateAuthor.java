package com.example.springboothttpmethods.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestResponseUpdateAuthor {
    private Long id;
    private String message;
    private String author;
    private LocalDateTime saveTime;
}
