package com.test.message.controller;

import com.test.message.domain.Message;
import com.test.message.domain.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/command")
    @SendTo("/topic/command")
    public String command(String command) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return time + ": " + command;
    }

    @MessageMapping("/messages")
    @SendTo("/topic/messages")
    public OutputMessage message(Message message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

}
