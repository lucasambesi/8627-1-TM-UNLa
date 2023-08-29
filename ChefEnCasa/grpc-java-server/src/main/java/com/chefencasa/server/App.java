package com.chefencasa.server;

import java.io.IOException;

import com.chefencasa.Controller.UserController;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    public App() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Iniciando servidor grpc");
        Server server = ServerBuilder.forPort(9001).addService(new UserController()).build();
        server.start();
        System.out.println("Servidor escuchando en puerto " + server.getPort());
        server.awaitTermination();
    }
}
