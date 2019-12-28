package com.iteco.mqsender.rest;

import com.iteco.mqsender.Application;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MessageController {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController (RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(path="/hello", method=GET)
    public String greeting() {
        return "Hello, I-teco!";
    }

    @RequestMapping(path="/", method=POST)
    public void sendMessage(@RequestBody String message) {
        System.out.println(message);
        try {
            System.out.println("Sending message: " + message);
            rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.buz", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
