package com.example;

import io.grpc.BindableService;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.Arrays;

public class GrpcServer {

    private final int port;
    private final BindableService[] services;

    public GrpcServer(int port, BindableService... services){
        this.port = port;
        this.services = services;
    }


    public void start()  {
        System.out.println("starting server");
        ServerBuilder builder = ServerBuilder.forPort(port);
        Arrays.stream(services).forEach(svc->builder.addService(svc));
        try {
            builder.build().start().awaitTermination();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
