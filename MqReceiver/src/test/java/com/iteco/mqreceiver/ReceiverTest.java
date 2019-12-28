package com.iteco.mqreceiver;

import com.iteco.mqreceiver.model.MessageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ReceiverTest {

    @Autowired
    private Receiver receiver;

    @Test
    public void insertMessageTest() {

        final String testMessage = "Test Message";
        MessageEntity newEntity = receiver.insertMessage(testMessage);

        assertNotNull(newEntity);

        assertEquals(testMessage, newEntity.getMessage());
    }
}
