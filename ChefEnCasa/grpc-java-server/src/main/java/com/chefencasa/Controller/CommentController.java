package com.chefencasa.Controller;

import com.chefencasa.service.CommentService;
import grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class CommentController extends CommentControllerGrpc.CommentControllerImplBase{

    public CommentService commentService = CommentService.getInstance();

    public CommentController() {
    }

    public void getComments(Comment.GetCommentRequest request, StreamObserver<Comment.CommentsDTO> responseObserver) {
        Comment.CommentsDTO.Builder response = Comment.CommentsDTO.newBuilder();
        Comment.CommentServerResponse.Builder serverResponse = Comment.CommentServerResponse.newBuilder();
        try {
            List<com.chefencasa.Model.Comment> com = commentService.getByRecipe(
                    request.getIdRecipe(),
                    request.getPageNumber(),
                    request.getPageSize()
            );
            for(com.chefencasa.Model.Comment p : com){
                response.addComments(mapCommentDTO(p));
            }
            serverResponse.setCode(200);
            serverResponse.setMsg("");
        } catch (Exception e) {
            serverResponse.setCode(500);
            serverResponse.setMsg(e.getMessage());
        }
        response.setServerResponse(serverResponse);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }


    private Comment.CommentDTO.Builder mapCommentDTO(com.chefencasa.Model.Comment c) throws Exception{
        Comment.CommentDTO.Builder commentDTO = Comment.CommentDTO.newBuilder();

        commentDTO.setIdComment(c.getIdComment());
        commentDTO.setValue(c.getValue());
        commentDTO.setUsername(c.getUser().getUsername());

        String name = c.getUser().getName() + " " + c.getUser().getLastname();
        commentDTO.setName(name);

        return commentDTO;
    }
}
