package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Recipe.proto")
public final class RecipeControllerGrpc {

  private RecipeControllerGrpc() {}

  public static final String SERVICE_NAME = "RecipeController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO,
      grpc.Recipe.RecipeObjDTO> getAddRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addRecipe",
      requestType = grpc.Recipe.RecipeDTO.class,
      responseType = grpc.Recipe.RecipeObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO,
      grpc.Recipe.RecipeObjDTO> getAddRecipeMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO, grpc.Recipe.RecipeObjDTO> getAddRecipeMethod;
    if ((getAddRecipeMethod = RecipeControllerGrpc.getAddRecipeMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getAddRecipeMethod = RecipeControllerGrpc.getAddRecipeMethod) == null) {
          RecipeControllerGrpc.getAddRecipeMethod = getAddRecipeMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.RecipeDTO, grpc.Recipe.RecipeObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "addRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipeDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipeObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("addRecipe"))
                  .build();
          }
        }
     }
     return getAddRecipeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO,
      grpc.Recipe.RecipeObjDTO> getUpdateRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRecipe",
      requestType = grpc.Recipe.RecipeDTO.class,
      responseType = grpc.Recipe.RecipeObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO,
      grpc.Recipe.RecipeObjDTO> getUpdateRecipeMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.RecipeDTO, grpc.Recipe.RecipeObjDTO> getUpdateRecipeMethod;
    if ((getUpdateRecipeMethod = RecipeControllerGrpc.getUpdateRecipeMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getUpdateRecipeMethod = RecipeControllerGrpc.getUpdateRecipeMethod) == null) {
          RecipeControllerGrpc.getUpdateRecipeMethod = getUpdateRecipeMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.RecipeDTO, grpc.Recipe.RecipeObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "updateRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipeDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipeObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("updateRecipe"))
                  .build();
          }
        }
     }
     return getUpdateRecipeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.GetRecipeRequest,
      grpc.Recipe.RecipeObjDTO> getGetRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRecipe",
      requestType = grpc.Recipe.GetRecipeRequest.class,
      responseType = grpc.Recipe.RecipeObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.GetRecipeRequest,
      grpc.Recipe.RecipeObjDTO> getGetRecipeMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.GetRecipeRequest, grpc.Recipe.RecipeObjDTO> getGetRecipeMethod;
    if ((getGetRecipeMethod = RecipeControllerGrpc.getGetRecipeMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getGetRecipeMethod = RecipeControllerGrpc.getGetRecipeMethod) == null) {
          RecipeControllerGrpc.getGetRecipeMethod = getGetRecipeMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.GetRecipeRequest, grpc.Recipe.RecipeObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "getRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.GetRecipeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipeObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("getRecipe"))
                  .build();
          }
        }
     }
     return getGetRecipeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.Empty,
      grpc.Recipe.RecipesDTO> getGetAllRecipesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllRecipes",
      requestType = grpc.Recipe.Empty.class,
      responseType = grpc.Recipe.RecipesDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.Empty,
      grpc.Recipe.RecipesDTO> getGetAllRecipesMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.Empty, grpc.Recipe.RecipesDTO> getGetAllRecipesMethod;
    if ((getGetAllRecipesMethod = RecipeControllerGrpc.getGetAllRecipesMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getGetAllRecipesMethod = RecipeControllerGrpc.getGetAllRecipesMethod) == null) {
          RecipeControllerGrpc.getGetAllRecipesMethod = getGetAllRecipesMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.Empty, grpc.Recipe.RecipesDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "getAllRecipes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipesDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("getAllRecipes"))
                  .build();
          }
        }
     }
     return getGetAllRecipesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest,
      grpc.Recipe.RecipesDTO> getGetRecipesByUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRecipesByUserId",
      requestType = grpc.Recipe.IdUserRequest.class,
      responseType = grpc.Recipe.RecipesDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest,
      grpc.Recipe.RecipesDTO> getGetRecipesByUserIdMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest, grpc.Recipe.RecipesDTO> getGetRecipesByUserIdMethod;
    if ((getGetRecipesByUserIdMethod = RecipeControllerGrpc.getGetRecipesByUserIdMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getGetRecipesByUserIdMethod = RecipeControllerGrpc.getGetRecipesByUserIdMethod) == null) {
          RecipeControllerGrpc.getGetRecipesByUserIdMethod = getGetRecipesByUserIdMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.IdUserRequest, grpc.Recipe.RecipesDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "getRecipesByUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.IdUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipesDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("getRecipesByUserId"))
                  .build();
          }
        }
     }
     return getGetRecipesByUserIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.GetByFilterRequest,
      grpc.Recipe.RecipesDTO> getGetByFilterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByFilter",
      requestType = grpc.Recipe.GetByFilterRequest.class,
      responseType = grpc.Recipe.RecipesDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.GetByFilterRequest,
      grpc.Recipe.RecipesDTO> getGetByFilterMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.GetByFilterRequest, grpc.Recipe.RecipesDTO> getGetByFilterMethod;
    if ((getGetByFilterMethod = RecipeControllerGrpc.getGetByFilterMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getGetByFilterMethod = RecipeControllerGrpc.getGetByFilterMethod) == null) {
          RecipeControllerGrpc.getGetByFilterMethod = getGetByFilterMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.GetByFilterRequest, grpc.Recipe.RecipesDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "getByFilter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.GetByFilterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipesDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("getByFilter"))
                  .build();
          }
        }
     }
     return getGetByFilterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest,
      grpc.Recipe.RecipesDTO> getGetFavotiresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFavotires",
      requestType = grpc.Recipe.IdUserRequest.class,
      responseType = grpc.Recipe.RecipesDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest,
      grpc.Recipe.RecipesDTO> getGetFavotiresMethod() {
    io.grpc.MethodDescriptor<grpc.Recipe.IdUserRequest, grpc.Recipe.RecipesDTO> getGetFavotiresMethod;
    if ((getGetFavotiresMethod = RecipeControllerGrpc.getGetFavotiresMethod) == null) {
      synchronized (RecipeControllerGrpc.class) {
        if ((getGetFavotiresMethod = RecipeControllerGrpc.getGetFavotiresMethod) == null) {
          RecipeControllerGrpc.getGetFavotiresMethod = getGetFavotiresMethod = 
              io.grpc.MethodDescriptor.<grpc.Recipe.IdUserRequest, grpc.Recipe.RecipesDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RecipeController", "getFavotires"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.IdUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Recipe.RecipesDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RecipeControllerMethodDescriptorSupplier("getFavotires"))
                  .build();
          }
        }
     }
     return getGetFavotiresMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecipeControllerStub newStub(io.grpc.Channel channel) {
    return new RecipeControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecipeControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecipeControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecipeControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RecipeControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class RecipeControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addRecipe(grpc.Recipe.RecipeDTO request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddRecipeMethod(), responseObserver);
    }

    /**
     */
    public void updateRecipe(grpc.Recipe.RecipeDTO request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRecipeMethod(), responseObserver);
    }

    /**
     */
    public void getRecipe(grpc.Recipe.GetRecipeRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRecipeMethod(), responseObserver);
    }

    /**
     */
    public void getAllRecipes(grpc.Recipe.Empty request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllRecipesMethod(), responseObserver);
    }

    /**
     */
    public void getRecipesByUserId(grpc.Recipe.IdUserRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRecipesByUserIdMethod(), responseObserver);
    }

    /**
     */
    public void getByFilter(grpc.Recipe.GetByFilterRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByFilterMethod(), responseObserver);
    }

    /**
     */
    public void getFavotires(grpc.Recipe.IdUserRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFavotiresMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddRecipeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.RecipeDTO,
                grpc.Recipe.RecipeObjDTO>(
                  this, METHODID_ADD_RECIPE)))
          .addMethod(
            getUpdateRecipeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.RecipeDTO,
                grpc.Recipe.RecipeObjDTO>(
                  this, METHODID_UPDATE_RECIPE)))
          .addMethod(
            getGetRecipeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.GetRecipeRequest,
                grpc.Recipe.RecipeObjDTO>(
                  this, METHODID_GET_RECIPE)))
          .addMethod(
            getGetAllRecipesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.Empty,
                grpc.Recipe.RecipesDTO>(
                  this, METHODID_GET_ALL_RECIPES)))
          .addMethod(
            getGetRecipesByUserIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.IdUserRequest,
                grpc.Recipe.RecipesDTO>(
                  this, METHODID_GET_RECIPES_BY_USER_ID)))
          .addMethod(
            getGetByFilterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.GetByFilterRequest,
                grpc.Recipe.RecipesDTO>(
                  this, METHODID_GET_BY_FILTER)))
          .addMethod(
            getGetFavotiresMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Recipe.IdUserRequest,
                grpc.Recipe.RecipesDTO>(
                  this, METHODID_GET_FAVOTIRES)))
          .build();
    }
  }

  /**
   */
  public static final class RecipeControllerStub extends io.grpc.stub.AbstractStub<RecipeControllerStub> {
    private RecipeControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecipeControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecipeControllerStub(channel, callOptions);
    }

    /**
     */
    public void addRecipe(grpc.Recipe.RecipeDTO request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddRecipeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRecipe(grpc.Recipe.RecipeDTO request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRecipeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRecipe(grpc.Recipe.GetRecipeRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRecipeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllRecipes(grpc.Recipe.Empty request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllRecipesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRecipesByUserId(grpc.Recipe.IdUserRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRecipesByUserIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByFilter(grpc.Recipe.GetByFilterRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFavotires(grpc.Recipe.IdUserRequest request,
        io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFavotiresMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecipeControllerBlockingStub extends io.grpc.stub.AbstractStub<RecipeControllerBlockingStub> {
    private RecipeControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecipeControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecipeControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Recipe.RecipeObjDTO addRecipe(grpc.Recipe.RecipeDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddRecipeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipeObjDTO updateRecipe(grpc.Recipe.RecipeDTO request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRecipeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipeObjDTO getRecipe(grpc.Recipe.GetRecipeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRecipeMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipesDTO getAllRecipes(grpc.Recipe.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllRecipesMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipesDTO getRecipesByUserId(grpc.Recipe.IdUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRecipesByUserIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipesDTO getByFilter(grpc.Recipe.GetByFilterRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetByFilterMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Recipe.RecipesDTO getFavotires(grpc.Recipe.IdUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetFavotiresMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecipeControllerFutureStub extends io.grpc.stub.AbstractStub<RecipeControllerFutureStub> {
    private RecipeControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecipeControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecipeControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RecipeControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipeObjDTO> addRecipe(
        grpc.Recipe.RecipeDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddRecipeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipeObjDTO> updateRecipe(
        grpc.Recipe.RecipeDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRecipeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipeObjDTO> getRecipe(
        grpc.Recipe.GetRecipeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRecipeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipesDTO> getAllRecipes(
        grpc.Recipe.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllRecipesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipesDTO> getRecipesByUserId(
        grpc.Recipe.IdUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRecipesByUserIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipesDTO> getByFilter(
        grpc.Recipe.GetByFilterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByFilterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Recipe.RecipesDTO> getFavotires(
        grpc.Recipe.IdUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFavotiresMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_RECIPE = 0;
  private static final int METHODID_UPDATE_RECIPE = 1;
  private static final int METHODID_GET_RECIPE = 2;
  private static final int METHODID_GET_ALL_RECIPES = 3;
  private static final int METHODID_GET_RECIPES_BY_USER_ID = 4;
  private static final int METHODID_GET_BY_FILTER = 5;
  private static final int METHODID_GET_FAVOTIRES = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecipeControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecipeControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_RECIPE:
          serviceImpl.addRecipe((grpc.Recipe.RecipeDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO>) responseObserver);
          break;
        case METHODID_UPDATE_RECIPE:
          serviceImpl.updateRecipe((grpc.Recipe.RecipeDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO>) responseObserver);
          break;
        case METHODID_GET_RECIPE:
          serviceImpl.getRecipe((grpc.Recipe.GetRecipeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipeObjDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_RECIPES:
          serviceImpl.getAllRecipes((grpc.Recipe.Empty) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO>) responseObserver);
          break;
        case METHODID_GET_RECIPES_BY_USER_ID:
          serviceImpl.getRecipesByUserId((grpc.Recipe.IdUserRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO>) responseObserver);
          break;
        case METHODID_GET_BY_FILTER:
          serviceImpl.getByFilter((grpc.Recipe.GetByFilterRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO>) responseObserver);
          break;
        case METHODID_GET_FAVOTIRES:
          serviceImpl.getFavotires((grpc.Recipe.IdUserRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Recipe.RecipesDTO>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RecipeControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecipeControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Recipe.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecipeController");
    }
  }

  private static final class RecipeControllerFileDescriptorSupplier
      extends RecipeControllerBaseDescriptorSupplier {
    RecipeControllerFileDescriptorSupplier() {}
  }

  private static final class RecipeControllerMethodDescriptorSupplier
      extends RecipeControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecipeControllerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RecipeControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecipeControllerFileDescriptorSupplier())
              .addMethod(getAddRecipeMethod())
              .addMethod(getUpdateRecipeMethod())
              .addMethod(getGetRecipeMethod())
              .addMethod(getGetAllRecipesMethod())
              .addMethod(getGetRecipesByUserIdMethod())
              .addMethod(getGetByFilterMethod())
              .addMethod(getGetFavotiresMethod())
              .build();
        }
      }
    }
    return result;
  }
}
