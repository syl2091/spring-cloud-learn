package com.lege.grpc.server;

import com.lege.grpc.HelloRequest;
import com.lege.grpc.HelloResponse;
import com.lege.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author lege
 * @Description
 * @create 2022-08-18 16:54
 */
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        String greeting = new StringBuilder().append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
