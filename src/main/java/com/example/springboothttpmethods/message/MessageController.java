package com.example.springboothttpmethods.message;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/new")
    public RestResponseNewMessage newMessage(@RequestBody RestRequestNewMessage restRequestNewMessage) {
        return messageService.createNew(restRequestNewMessage);
    }
}
