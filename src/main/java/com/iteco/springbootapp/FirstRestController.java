package com.iteco.springbootapp;

import com.iteco.springbootapp.rabbit.Receiver;
import com.iteco.springbootapp.rabbit.Runner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class FirstRestController {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Autowired
    public FirstRestController (RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(path = "/greeting", method=GET)
    public String greeting() {
        return "Hello, I-teco!";
    }

    @RequestMapping(path="/", method=POST)
    public void sendMessage(@RequestBody String message) {
        System.out.println(message);
        try {
            System.out.println("Sending message ... ");
            rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.buz", message);
            receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
