package com.lege.grpc.client;

import com.lege.grpc.HelloRequest;
import com.lege.grpc.HelloResponse;
import com.lege.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author lege
 * @Description 客户端
 * @create 2022-08-19 13:59
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("lege")
                .setLastName("gRPC")
                .build());

        channel.shutdown();
    }
}
