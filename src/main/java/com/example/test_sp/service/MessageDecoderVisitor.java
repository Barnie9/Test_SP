package com.example.test_sp.service;

import com.example.test_sp.model.Message;
import com.example.test_sp.model.Visitor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class MessageDecoderVisitor implements Visitor {

    private JSONArray jsonArray = new JSONArray();

    public void visit(Message message) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("house", message.getHouse());
        jsonObject.put("message", message.decode());
        jsonObject.put("date", message.getDate().toString());

        jsonArray.put(jsonObject);
    }

    public void exportJSON() {
        try (FileWriter file = new FileWriter("src/DecodedMessages.json")) {
            file.write(jsonArray.toString(4));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println(jsonArray.toString(4));
    }
}
