package com.example.test_sp.controller;

import com.example.test_sp.model.Message;
import com.example.test_sp.service.MessageDecoderVisitor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @RequestMapping("/decode/print")
    public String decode() {
        List<Message> messages = new ArrayList<>();

        try {
            messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MessageDecoderVisitor visitor = new MessageDecoderVisitor();

        for (Message message : messages) {
            message.accept(visitor);
        }

        return visitor.getJSON();
    }

    @RequestMapping("/decode/export")
    public void export() {
        List<Message> messages = new ArrayList<>();

        try {
            messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MessageDecoderVisitor visitor = new MessageDecoderVisitor();

        for (Message message : messages) {
            message.accept(visitor);
        }

        visitor.exportJSON();
    }

    @RequestMapping("/all")
    public String all() {
        List<Message> messages = new ArrayList<>();

        try {
            messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String output = "";

        for (Message message : messages) {
            output += message.toString() + "\n";
        }

        return output;
    }
}
