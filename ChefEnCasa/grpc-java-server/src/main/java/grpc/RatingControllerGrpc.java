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
    comments = "Source: Rating.proto")
public final class RatingControllerGrpc {

  private RatingControllerGrpc() {}

  public static final String SERVICE_NAME = "RatingController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Rating.RatingDTO,
      grpc.Rating.RatingObjDTO> getAddRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addRating",
      requestType = grpc.Rating.RatingDTO.class,
      responseType = grpc.Rating.RatingObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Rating.RatingDTO,
      grpc.Rating.RatingObjDTO> getAddRatingMethod() {
    io.grpc.MethodDescriptor<grpc.Rating.RatingDTO, grpc.Rating.RatingObjDTO> getAddRatingMethod;
    if ((getAddRatingMethod = RatingControllerGrpc.getAddRatingMethod) == null) {
      synchronized (RatingControllerGrpc.class) {
        if ((getAddRatingMethod = RatingControllerGrpc.getAddRatingMethod) == null) {
          RatingControllerGrpc.getAddRatingMethod = getAddRatingMethod = 
              io.grpc.MethodDescriptor.<grpc.Rating.RatingDTO, grpc.Rating.RatingObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RatingController", "addRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RatingControllerMethodDescriptorSupplier("addRating"))
                  .build();
          }
        }
     }
     return getAddRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Rating.RatingDTO,
      grpc.Rating.RatingObjDTO> getUpdateRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateRating",
      requestType = grpc.Rating.RatingDTO.class,
      responseType = grpc.Rating.RatingObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Rating.RatingDTO,
      grpc.Rating.RatingObjDTO> getUpdateRatingMethod() {
    io.grpc.MethodDescriptor<grpc.Rating.RatingDTO, grpc.Rating.RatingObjDTO> getUpdateRatingMethod;
    if ((getUpdateRatingMethod = RatingControllerGrpc.getUpdateRatingMethod) == null) {
      synchronized (RatingControllerGrpc.class) {
        if ((getUpdateRatingMethod = RatingControllerGrpc.getUpdateRatingMethod) == null) {
          RatingControllerGrpc.getUpdateRatingMethod = getUpdateRatingMethod = 
              io.grpc.MethodDescriptor.<grpc.Rating.RatingDTO, grpc.Rating.RatingObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RatingController", "updateRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RatingControllerMethodDescriptorSupplier("updateRating"))
                  .build();
          }
        }
     }
     return getUpdateRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Rating.GetRatingRequest,
      grpc.Rating.RatingObjDTO> getGetRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRating",
      requestType = grpc.Rating.GetRatingRequest.class,
      responseType = grpc.Rating.RatingObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Rating.GetRatingRequest,
      grpc.Rating.RatingObjDTO> getGetRatingMethod() {
    io.grpc.MethodDescriptor<grpc.Rating.GetRatingRequest, grpc.Rating.RatingObjDTO> getGetRatingMethod;
    if ((getGetRatingMethod = RatingControllerGrpc.getGetRatingMethod) == null) {
      synchronized (RatingControllerGrpc.class) {
        if ((getGetRatingMethod = RatingControllerGrpc.getGetRatingMethod) == null) {
          RatingControllerGrpc.getGetRatingMethod = getGetRatingMethod = 
              io.grpc.MethodDescriptor.<grpc.Rating.GetRatingRequest, grpc.Rating.RatingObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RatingController", "getRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.GetRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RatingControllerMethodDescriptorSupplier("getRating"))
                  .build();
          }
        }
     }
     return getGetRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Rating.GetRatingAvgRequest,
      grpc.Rating.RatingRecipeResponse> getGetAverageRatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAverageRating",
      requestType = grpc.Rating.GetRatingAvgRequest.class,
      responseType = grpc.Rating.RatingRecipeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Rating.GetRatingAvgRequest,
      grpc.Rating.RatingRecipeResponse> getGetAverageRatingMethod() {
    io.grpc.MethodDescriptor<grpc.Rating.GetRatingAvgRequest, grpc.Rating.RatingRecipeResponse> getGetAverageRatingMethod;
    if ((getGetAverageRatingMethod = RatingControllerGrpc.getGetAverageRatingMethod) == null) {
      synchronized (RatingControllerGrpc.class) {
        if ((getGetAverageRatingMethod = RatingControllerGrpc.getGetAverageRatingMethod) == null) {
          RatingControllerGrpc.getGetAverageRatingMethod = getGetAverageRatingMethod = 
              io.grpc.MethodDescriptor.<grpc.Rating.GetRatingAvgRequest, grpc.Rating.RatingRecipeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RatingController", "getAverageRating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.GetRatingAvgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingRecipeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RatingControllerMethodDescriptorSupplier("getAverageRating"))
                  .build();
          }
        }
     }
     return getGetAverageRatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Rating.UserAndRecipeRatingRequest,
      grpc.Rating.RatingObjDTO> getGetRatingByUserAndRecipeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRatingByUserAndRecipe",
      requestType = grpc.Rating.UserAndRecipeRatingRequest.class,
      responseType = grpc.Rating.RatingObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Rating.UserAndRecipeRatingRequest,
      grpc.Rating.RatingObjDTO> getGetRatingByUserAndRecipeMethod() {
    io.grpc.MethodDescriptor<grpc.Rating.UserAndRecipeRatingRequest, grpc.Rating.RatingObjDTO> getGetRatingByUserAndRecipeMethod;
    if ((getGetRatingByUserAndRecipeMethod = RatingControllerGrpc.getGetRatingByUserAndRecipeMethod) == null) {
      synchronized (RatingControllerGrpc.class) {
        if ((getGetRatingByUserAndRecipeMethod = RatingControllerGrpc.getGetRatingByUserAndRecipeMethod) == null) {
          RatingControllerGrpc.getGetRatingByUserAndRecipeMethod = getGetRatingByUserAndRecipeMethod = 
              io.grpc.MethodDescriptor.<grpc.Rating.UserAndRecipeRatingRequest, grpc.Rating.RatingObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RatingController", "getRatingByUserAndRecipe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.UserAndRecipeRatingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Rating.RatingObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new RatingControllerMethodDescriptorSupplier("getRatingByUserAndRecipe"))
                  .build();
          }
        }
     }
     return getGetRatingByUserAndRecipeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RatingControllerStub newStub(io.grpc.Channel channel) {
    return new RatingControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RatingControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RatingControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RatingControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RatingControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class RatingControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addRating(grpc.Rating.RatingDTO request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddRatingMethod(), responseObserver);
    }

    /**
     */
    public void updateRating(grpc.Rating.RatingDTO request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateRatingMethod(), responseObserver);
    }

    /**
     */
    public void getRating(grpc.Rating.GetRatingRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRatingMethod(), responseObserver);
    }

    /**
     */
    public void getAverageRating(grpc.Rating.GetRatingAvgRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingRecipeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAverageRatingMethod(), responseObserver);
    }

    /**
     */
    public void getRatingByUserAndRecipe(grpc.Rating.UserAndRecipeRatingRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRatingByUserAndRecipeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddRatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Rating.RatingDTO,
                grpc.Rating.RatingObjDTO>(
                  this, METHODID_ADD_RATING)))
          .addMethod(
            getUpdateRatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Rating.RatingDTO,
                grpc.Rating.RatingObjDTO>(
                  this, METHODID_UPDATE_RATING)))
          .addMethod(
            getGetRatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Rating.GetRatingRequest,
                grpc.Rating.RatingObjDTO>(
                  this, METHODID_GET_RATING)))
          .addMethod(
            getGetAverageRatingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Rating.GetRatingAvgRequest,
                grpc.Rating.RatingRecipeResponse>(
                  this, METHODID_GET_AVERAGE_RATING)))
          .addMethod(
            getGetRatingByUserAndRecipeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Rating.UserAndRecipeRatingRequest,
                grpc.Rating.RatingObjDTO>(
                  this, METHODID_GET_RATING_BY_USER_AND_RECIPE)))
          .build();
    }
  }

  /**
   */
  public static final class RatingControllerStub extends io.grpc.stub.AbstractStub<RatingControllerStub> {
    private RatingControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RatingControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RatingControllerStub(channel, callOptions);
    }

    /**
     */
    public void addRating(grpc.Rating.RatingDTO request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateRating(grpc.Rating.RatingDTO request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRating(grpc.Rating.GetRatingRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAverageRating(grpc.Rating.GetRatingAvgRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingRecipeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAverageRatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRatingByUserAndRecipe(grpc.Rating.UserAndRecipeRatingRequest request,
        io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRatingByUserAndRecipeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RatingControllerBlockingStub extends io.grpc.stub.AbstractStub<RatingControllerBlockingStub> {
    private RatingControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RatingControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RatingControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Rating.RatingObjDTO addRating(grpc.Rating.RatingDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Rating.RatingObjDTO updateRating(grpc.Rating.RatingDTO request) {
      return blockingUnaryCall(
          getChannel(), getUpdateRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Rating.RatingObjDTO getRating(grpc.Rating.GetRatingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Rating.RatingRecipeResponse getAverageRating(grpc.Rating.GetRatingAvgRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAverageRatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Rating.RatingObjDTO getRatingByUserAndRecipe(grpc.Rating.UserAndRecipeRatingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRatingByUserAndRecipeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RatingControllerFutureStub extends io.grpc.stub.AbstractStub<RatingControllerFutureStub> {
    private RatingControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RatingControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RatingControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RatingControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Rating.RatingObjDTO> addRating(
        grpc.Rating.RatingDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Rating.RatingObjDTO> updateRating(
        grpc.Rating.RatingDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Rating.RatingObjDTO> getRating(
        grpc.Rating.GetRatingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Rating.RatingRecipeResponse> getAverageRating(
        grpc.Rating.GetRatingAvgRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAverageRatingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Rating.RatingObjDTO> getRatingByUserAndRecipe(
        grpc.Rating.UserAndRecipeRatingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRatingByUserAndRecipeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_RATING = 0;
  private static final int METHODID_UPDATE_RATING = 1;
  private static final int METHODID_GET_RATING = 2;
  private static final int METHODID_GET_AVERAGE_RATING = 3;
  private static final int METHODID_GET_RATING_BY_USER_AND_RECIPE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RatingControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RatingControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_RATING:
          serviceImpl.addRating((grpc.Rating.RatingDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO>) responseObserver);
          break;
        case METHODID_UPDATE_RATING:
          serviceImpl.updateRating((grpc.Rating.RatingDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO>) responseObserver);
          break;
        case METHODID_GET_RATING:
          serviceImpl.getRating((grpc.Rating.GetRatingRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO>) responseObserver);
          break;
        case METHODID_GET_AVERAGE_RATING:
          serviceImpl.getAverageRating((grpc.Rating.GetRatingAvgRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Rating.RatingRecipeResponse>) responseObserver);
          break;
        case METHODID_GET_RATING_BY_USER_AND_RECIPE:
          serviceImpl.getRatingByUserAndRecipe((grpc.Rating.UserAndRecipeRatingRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Rating.RatingObjDTO>) responseObserver);
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

  private static abstract class RatingControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RatingControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Rating.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RatingController");
    }
  }

  private static final class RatingControllerFileDescriptorSupplier
      extends RatingControllerBaseDescriptorSupplier {
    RatingControllerFileDescriptorSupplier() {}
  }

  private static final class RatingControllerMethodDescriptorSupplier
      extends RatingControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RatingControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (RatingControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RatingControllerFileDescriptorSupplier())
              .addMethod(getAddRatingMethod())
              .addMethod(getUpdateRatingMethod())
              .addMethod(getGetRatingMethod())
              .addMethod(getGetAverageRatingMethod())
              .addMethod(getGetRatingByUserAndRecipeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
