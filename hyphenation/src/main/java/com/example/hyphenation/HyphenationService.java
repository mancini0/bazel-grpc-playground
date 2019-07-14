package com.example.hyphenation;


import io.grpc.stub.StreamObserver;

public class HyphenationService extends HyphenationServiceGrpc.HyphenationServiceImplBase {


    public void hyphenateUnderscores(Hyphenation.HyphenationRequest request,
                                     StreamObserver<Hyphenation.HyphenationResponse> responseObserver) {

        String hyphenated = request.getStr().replace("_", "-");
        responseObserver.onNext(Hyphenation.HyphenationResponse.newBuilder().setStr(hyphenated).build());
        responseObserver.onCompleted();
    }


    public void hyphenateSpaces(Hyphenation.HyphenationRequest request,
                                StreamObserver<Hyphenation.HyphenationResponse> responseObserver) {

        String hyphenated = request.getStr().replace(" ", "-");
        responseObserver.onNext(Hyphenation.HyphenationResponse.newBuilder().setStr(hyphenated).build());
        responseObserver.onCompleted();
    }


}
