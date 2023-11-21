package com.example.test_sp.service;

public class DecoderFactory {

    private Decoder decoder;

    public DecoderFactory() {
    }

    public Decoder createDecoder(String house) {
        if (house.equals("atreides")) {
            this.decoder = new AtreidesDecoder();
        } else if (house.equals("harkonnen")) {
            this.decoder = new HarkonnenDecoder();
        } else {
            this.decoder = null;
        }

        return this.decoder;
    }
}
