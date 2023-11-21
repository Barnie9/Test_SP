package com.example.test_sp.model;

import com.example.test_sp.service.DecoderFactory;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Message implements Visitee {
    private Date date;
    private String message;
    private String house;

    public Message() {
    }

    public Message(Date date, String message, String house) {
        this.date = date;
        this.message = message;
        this.house = house;
    }

    public String decode() {
        return new DecoderFactory().createDecoder(this.house).decode(this.message);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String toString() {
        return "Message: " + message + "\nHouse: " + house + "\nTimestamp: " + date;
    }

    public void print() {
        System.out.println("Message: " + message);
        System.out.println("House: " + house);
        System.out.println("Timestamp: " + date);
    }
}
