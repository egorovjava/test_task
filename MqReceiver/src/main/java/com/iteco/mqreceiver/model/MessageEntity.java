package com.iteco.mqreceiver.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="messages")
public class MessageEntity {

    private UUID id;
    private String message;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public UUID getId() {
        return id;
    }

    public void  setId(UUID id) {
        this.id = id;
    }

    @Column(name="message_text")
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        MessageEntity entity = (MessageEntity)o;
        return Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }

    @Override
    public String toString() {
        return this.id + "; " + this.message;
    }
}
