package com.iteco.springbootapp.rabbit;

import com.iteco.springbootapp.Application;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Autowired
    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String ... args) throws Exception {
        //System.out.println("Sending message ... ");
        //rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.buz", "Hello, from Rabbit!");
        //receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }
}
