package com.iteco.mqreceiver;

import com.iteco.mqreceiver.model.MessageEntity;
import com.iteco.mqreceiver.model.MessagesRepository;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private final MessagesRepository messagesRepository;

    public Receiver(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public void receiveMessage(String message) {
        System.out.println("Received message < " + message + " >");
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessage(message);
        MessageEntity newMessage = messagesRepository.save(messageEntity);
        if(newMessage != null) {
            System.out.println("Message \"" + newMessage.getMessage() + "\" saved with id " + newMessage.getId());
        } else {
            System.out.println("Message \"" + message + "\" hasn't saving.");
        }
    }

}
