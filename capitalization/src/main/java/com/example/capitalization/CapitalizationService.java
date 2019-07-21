package com.example.capitalization;

import io.grpc.stub.StreamObserver;
import javax.inject.Inject;

public class CapitalizationService extends CapitalizationServiceGrpc.CapitalizationServiceImplBase {

    private final FooService fooService;


    @Inject
    public CapitalizationService(FooService fooService){
        this.fooService=fooService;
    }

    @Override
    public void lowercase(Capitalization.CapitalizationRequest request,
                                     StreamObserver<Capitalization.CapitalizationResponse> responseObserver) {
        String lower = request.getStr().toLowerCase();
        responseObserver.onNext(Capitalization.CapitalizationResponse.newBuilder().setStr(lower).build());
        responseObserver.onCompleted();
    }

    @Override
    public void uppercase(Capitalization.CapitalizationRequest request,
                                StreamObserver<Capitalization.CapitalizationResponse> responseObserver) {

        String upper = request.getStr().toUpperCase();
        responseObserver.onNext(Capitalization.CapitalizationResponse.newBuilder().setStr(upper).build());
        responseObserver.onCompleted();
    }


}
