package com.chefencasa.server;

import java.io.IOException;

import com.chefencasa.Controller.CategoryController;
import com.chefencasa.Controller.RecipeController;
import com.chefencasa.Controller.StepController;
import com.chefencasa.Controller.UserController;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    public App() {
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server grpc starting");
        Server server = ServerBuilder.forPort(9001)
                .addService(new CategoryController())
                .addService(new UserController())
                .addService(new RecipeController())
                .addService(new StepController())
                .build();
        server.start();
        System.out.println("Server listening on port " + server.getPort());
        server.awaitTermination();
    }
}