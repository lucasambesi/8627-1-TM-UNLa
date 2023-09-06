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
    comments = "Source: Step.proto")
public final class StepControllerGrpc {

  private StepControllerGrpc() {}

  public static final String SERVICE_NAME = "StepController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Step.StepDTO,
      grpc.Step.StepObjDTO> getAddStepMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStep",
      requestType = grpc.Step.StepDTO.class,
      responseType = grpc.Step.StepObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Step.StepDTO,
      grpc.Step.StepObjDTO> getAddStepMethod() {
    io.grpc.MethodDescriptor<grpc.Step.StepDTO, grpc.Step.StepObjDTO> getAddStepMethod;
    if ((getAddStepMethod = StepControllerGrpc.getAddStepMethod) == null) {
      synchronized (StepControllerGrpc.class) {
        if ((getAddStepMethod = StepControllerGrpc.getAddStepMethod) == null) {
          StepControllerGrpc.getAddStepMethod = getAddStepMethod = 
              io.grpc.MethodDescriptor.<grpc.Step.StepDTO, grpc.Step.StepObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StepController", "addStep"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Step.StepDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Step.StepObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new StepControllerMethodDescriptorSupplier("addStep"))
                  .build();
          }
        }
     }
     return getAddStepMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Step.IdRecipeRequest,
      grpc.Step.StepsDTO> getGetStepsByRecipeIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStepsByRecipeId",
      requestType = grpc.Step.IdRecipeRequest.class,
      responseType = grpc.Step.StepsDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Step.IdRecipeRequest,
      grpc.Step.StepsDTO> getGetStepsByRecipeIdMethod() {
    io.grpc.MethodDescriptor<grpc.Step.IdRecipeRequest, grpc.Step.StepsDTO> getGetStepsByRecipeIdMethod;
    if ((getGetStepsByRecipeIdMethod = StepControllerGrpc.getGetStepsByRecipeIdMethod) == null) {
      synchronized (StepControllerGrpc.class) {
        if ((getGetStepsByRecipeIdMethod = StepControllerGrpc.getGetStepsByRecipeIdMethod) == null) {
          StepControllerGrpc.getGetStepsByRecipeIdMethod = getGetStepsByRecipeIdMethod = 
              io.grpc.MethodDescriptor.<grpc.Step.IdRecipeRequest, grpc.Step.StepsDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StepController", "getStepsByRecipeId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Step.IdRecipeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Step.StepsDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new StepControllerMethodDescriptorSupplier("getStepsByRecipeId"))
                  .build();
          }
        }
     }
     return getGetStepsByRecipeIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StepControllerStub newStub(io.grpc.Channel channel) {
    return new StepControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StepControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StepControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StepControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StepControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class StepControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addStep(grpc.Step.StepDTO request,
        io.grpc.stub.StreamObserver<grpc.Step.StepObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddStepMethod(), responseObserver);
    }

    /**
     */
    public void getStepsByRecipeId(grpc.Step.IdRecipeRequest request,
        io.grpc.stub.StreamObserver<grpc.Step.StepsDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStepsByRecipeIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddStepMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Step.StepDTO,
                grpc.Step.StepObjDTO>(
                  this, METHODID_ADD_STEP)))
          .addMethod(
            getGetStepsByRecipeIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Step.IdRecipeRequest,
                grpc.Step.StepsDTO>(
                  this, METHODID_GET_STEPS_BY_RECIPE_ID)))
          .build();
    }
  }

  /**
   */
  public static final class StepControllerStub extends io.grpc.stub.AbstractStub<StepControllerStub> {
    private StepControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StepControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StepControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StepControllerStub(channel, callOptions);
    }

    /**
     */
    public void addStep(grpc.Step.StepDTO request,
        io.grpc.stub.StreamObserver<grpc.Step.StepObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddStepMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStepsByRecipeId(grpc.Step.IdRecipeRequest request,
        io.grpc.stub.StreamObserver<grpc.Step.StepsDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStepsByRecipeIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StepControllerBlockingStub extends io.grpc.stub.AbstractStub<StepControllerBlockingStub> {
    private StepControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StepControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StepControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StepControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Step.StepObjDTO addStep(grpc.Step.StepDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddStepMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Step.StepsDTO getStepsByRecipeId(grpc.Step.IdRecipeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStepsByRecipeIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StepControllerFutureStub extends io.grpc.stub.AbstractStub<StepControllerFutureStub> {
    private StepControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StepControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StepControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StepControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Step.StepObjDTO> addStep(
        grpc.Step.StepDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddStepMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Step.StepsDTO> getStepsByRecipeId(
        grpc.Step.IdRecipeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStepsByRecipeIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STEP = 0;
  private static final int METHODID_GET_STEPS_BY_RECIPE_ID = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StepControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StepControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STEP:
          serviceImpl.addStep((grpc.Step.StepDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Step.StepObjDTO>) responseObserver);
          break;
        case METHODID_GET_STEPS_BY_RECIPE_ID:
          serviceImpl.getStepsByRecipeId((grpc.Step.IdRecipeRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Step.StepsDTO>) responseObserver);
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

  private static abstract class StepControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StepControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Step.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StepController");
    }
  }

  private static final class StepControllerFileDescriptorSupplier
      extends StepControllerBaseDescriptorSupplier {
    StepControllerFileDescriptorSupplier() {}
  }

  private static final class StepControllerMethodDescriptorSupplier
      extends StepControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StepControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (StepControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StepControllerFileDescriptorSupplier())
              .addMethod(getAddStepMethod())
              .addMethod(getGetStepsByRecipeIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
