package com.example.springboothttpmethods.message;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true, fluent = true)
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    private LocalDateTime saveTime;
    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", saveTime=" + saveTime +
                '}';
    }
}
