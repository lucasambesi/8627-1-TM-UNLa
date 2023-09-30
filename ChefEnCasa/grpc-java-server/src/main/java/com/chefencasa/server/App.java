package com.chefencasa.server;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.chefencasa.Controller.*;
import com.chefencasa.Infraestructure.Job.CommentJob;
import com.chefencasa.Infraestructure.Job.JobService;
import com.chefencasa.Infraestructure.Job.PopularityRecipeJob;
import com.chefencasa.Infraestructure.Job.PopularityUserJob;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    private static final JobService<PopularityRecipeJob> popularityRecipeJob =
            new JobService<>(
                    PopularityRecipeJob.class,
                    "popularity-recipe-job",
                    "popularity-recipe-group",
                    "popularity-recipe-trigger",
                    "popularity-recipe-trigger-group",
                    5,
                    "popularity-recipe-scheduler");

    private static final JobService<PopularityUserJob> popularityUserJob =
            new JobService<>(
                    PopularityUserJob.class,
                    "popularity-user-job",
                    "popularity-user-group",
                    "popularity-user-trigger",
                    "popularity-user-trigger-group",
                    5,
                    "popularity-user-scheduler");

    private static final JobService<CommentJob> commentJob =
            new JobService<>(
                    CommentJob.class,
                    "comment-job",
                    "comment-group",
                    "comment-trigger",
                    "comment-trigger-group",
                    5,
                    "comment-scheduler");

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server grpc starting");

        scheduler.scheduleAtFixedRate(commentJob, 0, 1, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(popularityUserJob, 0, 1, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(popularityRecipeJob, 0, 1, TimeUnit.MINUTES);

        Server server = ServerBuilder.forPort(9003)
                .maxInboundMessageSize(1000 * 1024 * 1024)
                .addService(new CategoryController())
                .addService(new UserController())
                .addService(new RecipeController())
                .addService(new StepController())
                .addService(new RatingController())
                .build();
        server.start();

        System.out.println("Server listening on port " + server.getPort());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down server...");
            scheduler.shutdown();
            try {
                scheduler.awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Server shutdown complete.");
        }));

        server.awaitTermination();
    }
}