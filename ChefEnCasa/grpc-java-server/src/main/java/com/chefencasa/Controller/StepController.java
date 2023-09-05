package com.chefencasa.Controller;

import com.chefencasa.service.StepService;
import grpc.Step;
import grpc.StepControllerGrpc;
import io.grpc.stub.StreamObserver;

public class StepController extends StepControllerGrpc.StepControllerImplBase {
    public StepService stepService = StepService.getInstance();

    public StepController() {
    }

    public void addStep(Step.StepDTO request, StreamObserver<Step.StepObjDTO> responseObserver) {
        Step.StepObjDTO.Builder response = Step.StepObjDTO.newBuilder();
        Step.StepServerResponse.Builder serverResponse = Step.StepServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Step step = this.stepService.addStep(request);
            response.setStep(this.mapStepDTO(step));
            serverResponse.setCode(200);
            serverResponse.setMsg("Step created");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public Step.StepDTO.Builder mapStepDTO (com.chefencasa.Model.Step u){
        Step.StepDTO.Builder dto = Step.StepDTO.newBuilder();
        dto.setIdStep(u.getIdStep());
        dto.setDescription(u.getDescription());
        dto.setIdRecipe(u.getRecipe().getIdRecipe());

        return dto;
    }
}
