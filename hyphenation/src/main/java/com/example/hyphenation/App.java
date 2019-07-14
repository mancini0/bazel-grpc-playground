package com.example.hyphenation;

import com.example.GrpcServer;

public class App {


    public static void main(String[] args) throws Exception{
        GrpcServer server = new GrpcServer(9999,new HyphenationService());
        server.start();
    }
}