package com.example.test_sp.service;

public class HarkonnenDecoder implements Decoder {
    @Override
    public String decode(String message) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            result += (char) (message.charAt(i) - 2);
        }
        return result;
    }
}
