package com.example.springboothttpmethods.message;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/new")
    public RestResponseNewMessage newMessage(@RequestBody RestRequestNewMessage restRequestNewMessage) {
        return messageService.createNew(restRequestNewMessage);
    }

    @PutMapping("/{messageId}")
    public RestResponseNewMessage updateMessage(@PathVariable("messageId") Long messageId,
                                                @RequestBody RestRequestNewMessage restRequestUpdateMessage) {
        return messageService.updateMessage(messageId, restRequestUpdateMessage);
    }
}
