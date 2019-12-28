package com.iteco.mqreceiver.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MessagesRepository extends JpaRepository<MessageEntity, UUID> {

}
