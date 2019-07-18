package com.example.capitalization;

import io.grpc.stub.StreamObserver;

public class CapitalizationService extends CapitalizationServiceGrpc.CapitalizationServiceImplBase {


    public void lowercase(Capitalization.CapitalizationRequest request,
                                     StreamObserver<Capitalization.CapitalizationResponse> responseObserver) {
        String lower = request.getStr().toLowerCase();
        responseObserver.onNext(Capitalization.CapitalizationResponse.newBuilder().setStr(lower).build());
        responseObserver.onCompleted();
    }


    public void uppercase(Capitalization.CapitalizationRequest request,
                                StreamObserver<Capitalization.CapitalizationResponse> responseObserver) {

        String upper = request.getStr().toUpperCase();
        responseObserver.onNext(Capitalization.CapitalizationResponse.newBuilder().setStr(upper).build());
        responseObserver.onCompleted();
    }


}
