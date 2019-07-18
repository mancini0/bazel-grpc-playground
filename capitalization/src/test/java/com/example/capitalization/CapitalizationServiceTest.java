package com.example.capitalization;

import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import io.grpc.testing.GrpcCleanupRule;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import static org.junit.Assert.*;



public class CapitalizationServiceTest {

    private CapitalizationServiceGrpc.CapitalizationServiceBlockingStub blockingStub;

    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();


    @Before
    public void setup() throws Exception{
        String serverName = InProcessServerBuilder.generateName();

        grpcCleanup.register(InProcessServerBuilder
                .forName(serverName).directExecutor().addService(new CapitalizationService()).build().start());

        this.blockingStub = CapitalizationServiceGrpc.newBlockingStub(

                grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    }

    @Test
    public void lower() throws Exception {
       Capitalization.CapitalizationResponse response =  blockingStub.lowercase(Capitalization.CapitalizationRequest.newBuilder().setStr("fOo").build());
       assertEquals("foo", response.getStr());
    }

    @Test
    public void upper() throws Exception {
        Capitalization.CapitalizationResponse response =  blockingStub.uppercase(Capitalization.CapitalizationRequest.newBuilder().setStr("foo").build());
        assertEquals("FOO", response.getStr());
    }


}
