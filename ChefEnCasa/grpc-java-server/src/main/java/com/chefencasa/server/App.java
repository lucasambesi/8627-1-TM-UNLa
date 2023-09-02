package com.chefencasa.server;

import java.io.IOException;

import com.chefencasa.Controller.UserController;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    public App() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server grpc starting");
        Server server = ServerBuilder.forPort(9001).addService(new UserController()).build();
        server.start();
        System.out.println("Server listening on port " + server.getPort());
        server.awaitTermination();
    }
}
