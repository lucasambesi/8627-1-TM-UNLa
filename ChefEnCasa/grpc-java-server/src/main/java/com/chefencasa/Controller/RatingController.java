package com.chefencasa.Controller;

import com.chefencasa.service.RatingService;
import grpc.RatingControllerGrpc;
import grpc.Rating;
import grpc.Recipe;
import io.grpc.stub.StreamObserver;

public class RatingController extends RatingControllerGrpc.RatingControllerImplBase {

    public RatingService ratingService = RatingService.getInstance();

    public RatingController() {
    }

    public void addRating(Rating.RatingDTO request, StreamObserver<Rating.RatingObjDTO> responseObserver) {
        Rating.RatingObjDTO.Builder response = Rating.RatingObjDTO.newBuilder();
        Rating.RatingServerResponse.Builder serverResponse = Rating.RatingServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Rating rating = this.ratingService.saveRating(request);
            response.setRating(this.mapRatingDTO(rating));
            serverResponse.setCode(200);
            serverResponse.setMsg("Rating created");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void updateRating(Rating.RatingDTO request, StreamObserver<Rating.RatingObjDTO> responseObserver) {
        Rating.RatingObjDTO.Builder response = Rating.RatingObjDTO.newBuilder();
        Rating.RatingServerResponse.Builder serverResponse = Rating.RatingServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Rating rating = this.ratingService.updateRating(request);
            response.setRating(this.mapRatingDTO(rating));
            serverResponse.setCode(200);
            serverResponse.setMsg("Rating updated");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getRating(Rating.GetRatingRequest request, StreamObserver<Rating.RatingObjDTO> responseObserver) {
        com.chefencasa.Model.Rating rating = null;
        Rating.RatingServerResponse.Builder serverResponse = Rating.RatingServerResponse.newBuilder();
        Rating.RatingObjDTO.Builder response = Rating.RatingObjDTO.newBuilder();

        try {
            rating = this.ratingService.getById(request.getIdRating());
            response.setRating(this.mapRatingDTO(rating));
            serverResponse.setCode(200);
            serverResponse.setMsg("Rating found");
        } catch (Exception var7) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var7.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getRatingByUserAndRecipe(Rating.UserAndRecipeRatingRequest request, StreamObserver<Rating.RatingObjDTO> responseObserver) {
        com.chefencasa.Model.Rating rating = null;
        Rating.RatingServerResponse.Builder serverResponse = Rating.RatingServerResponse.newBuilder();
        Rating.RatingObjDTO.Builder response = Rating.RatingObjDTO.newBuilder();

        try {
            rating = this.ratingService.getRatingByUserAndRecipe(request.getIdUser(), request.getIdRecipe());
            response.setRating(this.mapRatingDTO(rating));
            serverResponse.setCode(200);
            serverResponse.setMsg("Rating found");

        } catch (Exception var7) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var7.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private Rating.RatingDTO.Builder mapRatingDTO(com.chefencasa.Model.Rating c) throws Exception{
        Rating.RatingDTO.Builder ratingDTO =Rating.RatingDTO.newBuilder();

        ratingDTO.setIdRating(c.getIdRating());
        ratingDTO.setIdRecipe(c.getRecipe().getIdRecipe());
        ratingDTO.setIdUser(c.getUser().getIdUser());
        ratingDTO.setValue(c.getValue());

        return ratingDTO;
    }
}
