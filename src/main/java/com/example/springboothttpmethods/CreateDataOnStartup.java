package com.example.springboothttpmethods;

import com.example.springboothttpmethods.message.MessageEntity;
import com.example.springboothttpmethods.message.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("mytest")
public class CreateDataOnStartup {
    private final MessageRepository repository;

    @PostConstruct
    void runOnStartup() {
        repository.save(MessageEntity.builder().message("sdfdsf").build());
        repository.save(MessageEntity.builder().message("sdfdsf").build());
        repository.save(MessageEntity.builder().message("sdfdsf").build());
        repository.save(MessageEntity.builder().message("sdfdsf").build());
    }
}
