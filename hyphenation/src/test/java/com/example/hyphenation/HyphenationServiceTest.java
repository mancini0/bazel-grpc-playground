package com.example.hyphenation;

import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import io.grpc.testing.GrpcCleanupRule;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import static org.junit.Assert.*;



public class HyphenationServiceTest {

    private HyphenationServiceGrpc.HyphenationServiceBlockingStub blockingStub;

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();


    @Before
    public void setup() throws Exception{
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new HyphenationService()).build().start());

        this.blockingStub = HyphenationServiceGrpc.newBlockingStub(

                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    }

    @Test
    public void spaces_unchanged() throws Exception {
       Hyphenation.HyphenationResponse response =  blockingStub.hyphenateSpaces(Hyphenation.HyphenationRequest.newBuilder().setStr("foo").build());
       assertEquals("foo", response.getStr());
    }

    @Test
    public void spaces_positive() throws Exception {
        Hyphenation.HyphenationResponse response =  blockingStub.hyphenateSpaces(Hyphenation.HyphenationRequest.newBuilder().setStr("foo bar").build());
        assertEquals("foo-bar", response.getStr());
    }


}
