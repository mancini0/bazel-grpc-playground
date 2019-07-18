package com.example.capitalization;

import com.example.GrpcServer;

public class App {


    public static void main(String[] args) throws Exception{
        GrpcServer server = new GrpcServer(9988,new com.example.capitalization.CapitalizationService());
        server.start();
    }
}