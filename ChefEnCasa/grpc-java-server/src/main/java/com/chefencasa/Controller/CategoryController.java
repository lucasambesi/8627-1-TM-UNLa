package com.chefencasa.Controller;

import com.chefencasa.service.CategoryService;
import grpc.Category;
import grpc.CategoryControllerGrpc;
import grpc.Recipe;
import grpc.User;
import io.grpc.stub.StreamObserver;

import java.util.List;

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

    public void getCategory(Category.GetCategoryRequest request, StreamObserver<Category.CategoryObjDTO> responseObserver) {
        com.chefencasa.Model.Category user = null;
        Category.CategoryServerResponse.Builder serverResponse = Category.CategoryServerResponse.newBuilder();
        Category.CategoryObjDTO.Builder response = Category.CategoryObjDTO.newBuilder();

        try {
            user = this.categoryService.getById(request.getIdCategory());
            response.setCategory(this.mapCategoryDTO(user));
            serverResponse.setCode(200);
            serverResponse.setMsg("Category found");
        } catch (Exception var7) {
            serverResponse.setCode(500);
            serverResponse.setMsg(var7.getMessage());
        }

        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void getAllCategories(Category.EmptyCategory request, StreamObserver<Category.CategoriesDTO> responseObserver) {
        Category.CategoriesDTO.Builder categoriesDTO = Category.CategoriesDTO.newBuilder();
        Category.CategoryServerResponse.Builder serverResponse = Category.CategoryServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Category> categories = this.categoryService.getAll();
            for (com.chefencasa.Model.Category category : categories) {
                categoriesDTO.addCategories(mapCategoryDTO(category));
            }
            categoriesDTO.setServerResponse(serverResponse);
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        responseObserver.onNext(categoriesDTO.build());
        responseObserver.onCompleted();
    }

    private Category.CategoryDTO.Builder mapCategoryDTO(com.chefencasa.Model.Category c) throws Exception{
        Category.CategoryDTO.Builder categoryDTO = Category.CategoryDTO.newBuilder();

        categoryDTO.setIdCategory(c.getIdCategory());
        categoryDTO.setName(c.getName());

        return categoryDTO;
    }
}
