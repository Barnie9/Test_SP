package com.example.test_sp;

import com.example.test_sp.model.Message;
import com.example.test_sp.service.MessageDecoderVisitor;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestSpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpApplication.class, args);

        List<Message> messages = new ArrayList<>();

        try {
            messages = new ObjectMapper().readValue(new URL("file:src/messages.json"), new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MessageDecoderVisitor visitor = new MessageDecoderVisitor();

        for (Message message : messages) {
            // message.print();

            // String result = message.decode();
            // System.out.println(result);

            message.accept(visitor);
        }

        visitor.exportJSON();
        visitor.print();
    }

}
