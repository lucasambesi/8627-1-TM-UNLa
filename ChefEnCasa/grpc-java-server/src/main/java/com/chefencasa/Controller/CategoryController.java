package com.chefencasa.Controller;

import com.chefencasa.service.CategoryService;
import grpc.Category;
import grpc.CategoryControllerGrpc;
import io.grpc.stub.StreamObserver;

public class CategoryController  extends CategoryControllerGrpc.CategoryControllerImplBase {

    public CategoryService categoryService = CategoryService.getInstance();

    public CategoryController() {
    }

    public void addCategory(Category.CategoryDTO request, StreamObserver<Category.CategoryObjDTO> responseObserver) {
        Category.CategoryObjDTO.Builder response = Category.CategoryObjDTO.newBuilder();
        Category.CategoryServerResponse.Builder serverResponse = Category.CategoryServerResponse.newBuilder();

        try {
            com.chefencasa.Model.Category category = this.categoryService.addCategory(request);
            response.setCategory(this.mapCategoryDTO(category));
            serverResponse.setCode(200);
            serverResponse.setMsg("Category created");
        } catch (Exception var6) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var6.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private Category.CategoryDTO.Builder mapCategoryDTO(com.chefencasa.Model.Category c) throws Exception{
        Category.CategoryDTO.Builder categoryDTO = Category.CategoryDTO.newBuilder();

        categoryDTO.setIdCategory(c.getIdCategory());
        categoryDTO.setName(c.getName());

        return categoryDTO;
    }
}
