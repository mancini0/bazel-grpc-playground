package com.example.capitalization;

import com.example.GrpcServer;
import com.example.capitalization.di.DaggerCapitalizationComponent;

public class App {


    public static void main(String[] args) throws Exception{
        GrpcServer server = new GrpcServer(9988, DaggerCapitalizationComponent.create().capitalizationService());
        server.start();
    }
}