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
    comments = "Source: User.proto")
public final class UserControllerGrpc {

  private UserControllerGrpc() {}

  public static final String SERVICE_NAME = "UserController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.User.UserDTO,
      grpc.User.UserObjDTO> getAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addUser",
      requestType = grpc.User.UserDTO.class,
      responseType = grpc.User.UserObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.User.UserDTO,
      grpc.User.UserObjDTO> getAddUserMethod() {
    io.grpc.MethodDescriptor<grpc.User.UserDTO, grpc.User.UserObjDTO> getAddUserMethod;
    if ((getAddUserMethod = UserControllerGrpc.getAddUserMethod) == null) {
      synchronized (UserControllerGrpc.class) {
        if ((getAddUserMethod = UserControllerGrpc.getAddUserMethod) == null) {
          UserControllerGrpc.getAddUserMethod = getAddUserMethod = 
              io.grpc.MethodDescriptor.<grpc.User.UserDTO, grpc.User.UserObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserController", "addUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.UserDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.UserObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UserControllerMethodDescriptorSupplier("addUser"))
                  .build();
          }
        }
     }
     return getAddUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.User.GetUserRequest,
      grpc.User.UserObjDTO> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUser",
      requestType = grpc.User.GetUserRequest.class,
      responseType = grpc.User.UserObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.User.GetUserRequest,
      grpc.User.UserObjDTO> getGetUserMethod() {
    io.grpc.MethodDescriptor<grpc.User.GetUserRequest, grpc.User.UserObjDTO> getGetUserMethod;
    if ((getGetUserMethod = UserControllerGrpc.getGetUserMethod) == null) {
      synchronized (UserControllerGrpc.class) {
        if ((getGetUserMethod = UserControllerGrpc.getGetUserMethod) == null) {
          UserControllerGrpc.getGetUserMethod = getGetUserMethod = 
              io.grpc.MethodDescriptor.<grpc.User.GetUserRequest, grpc.User.UserObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserController", "getUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.GetUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.UserObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UserControllerMethodDescriptorSupplier("getUser"))
                  .build();
          }
        }
     }
     return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.User.GetByUserIdAndPasswordRequest,
      grpc.User.UserObjDTO> getGetByUserAndPasswordRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByUserAndPasswordRequest",
      requestType = grpc.User.GetByUserIdAndPasswordRequest.class,
      responseType = grpc.User.UserObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.User.GetByUserIdAndPasswordRequest,
      grpc.User.UserObjDTO> getGetByUserAndPasswordRequestMethod() {
    io.grpc.MethodDescriptor<grpc.User.GetByUserIdAndPasswordRequest, grpc.User.UserObjDTO> getGetByUserAndPasswordRequestMethod;
    if ((getGetByUserAndPasswordRequestMethod = UserControllerGrpc.getGetByUserAndPasswordRequestMethod) == null) {
      synchronized (UserControllerGrpc.class) {
        if ((getGetByUserAndPasswordRequestMethod = UserControllerGrpc.getGetByUserAndPasswordRequestMethod) == null) {
          UserControllerGrpc.getGetByUserAndPasswordRequestMethod = getGetByUserAndPasswordRequestMethod = 
              io.grpc.MethodDescriptor.<grpc.User.GetByUserIdAndPasswordRequest, grpc.User.UserObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "UserController", "getByUserAndPasswordRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.GetByUserIdAndPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.User.UserObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new UserControllerMethodDescriptorSupplier("getByUserAndPasswordRequest"))
                  .build();
          }
        }
     }
     return getGetByUserAndPasswordRequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserControllerStub newStub(io.grpc.Channel channel) {
    return new UserControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class UserControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addUser(grpc.User.UserDTO request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUserMethod(), responseObserver);
    }

    /**
     */
    public void getUser(grpc.User.GetUserRequest request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     */
    public void getByUserAndPasswordRequest(grpc.User.GetByUserIdAndPasswordRequest request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByUserAndPasswordRequestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.User.UserDTO,
                grpc.User.UserObjDTO>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getGetUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.User.GetUserRequest,
                grpc.User.UserObjDTO>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getGetByUserAndPasswordRequestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.User.GetByUserIdAndPasswordRequest,
                grpc.User.UserObjDTO>(
                  this, METHODID_GET_BY_USER_AND_PASSWORD_REQUEST)))
          .build();
    }
  }

  /**
   */
  public static final class UserControllerStub extends io.grpc.stub.AbstractStub<UserControllerStub> {
    private UserControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserControllerStub(channel, callOptions);
    }

    /**
     */
    public void addUser(grpc.User.UserDTO request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUser(grpc.User.GetUserRequest request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByUserAndPasswordRequest(grpc.User.GetByUserIdAndPasswordRequest request,
        io.grpc.stub.StreamObserver<grpc.User.UserObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByUserAndPasswordRequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserControllerBlockingStub extends io.grpc.stub.AbstractStub<UserControllerBlockingStub> {
    private UserControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.User.UserObjDTO addUser(grpc.User.UserDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.User.UserObjDTO getUser(grpc.User.GetUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.User.UserObjDTO getByUserAndPasswordRequest(grpc.User.GetByUserIdAndPasswordRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetByUserAndPasswordRequestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserControllerFutureStub extends io.grpc.stub.AbstractStub<UserControllerFutureStub> {
    private UserControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.User.UserObjDTO> addUser(
        grpc.User.UserDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.User.UserObjDTO> getUser(
        grpc.User.GetUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.User.UserObjDTO> getByUserAndPasswordRequest(
        grpc.User.GetByUserIdAndPasswordRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByUserAndPasswordRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_USER = 0;
  private static final int METHODID_GET_USER = 1;
  private static final int METHODID_GET_BY_USER_AND_PASSWORD_REQUEST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_USER:
          serviceImpl.addUser((grpc.User.UserDTO) request,
              (io.grpc.stub.StreamObserver<grpc.User.UserObjDTO>) responseObserver);
          break;
        case METHODID_GET_USER:
          serviceImpl.getUser((grpc.User.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<grpc.User.UserObjDTO>) responseObserver);
          break;
        case METHODID_GET_BY_USER_AND_PASSWORD_REQUEST:
          serviceImpl.getByUserAndPasswordRequest((grpc.User.GetByUserIdAndPasswordRequest) request,
              (io.grpc.stub.StreamObserver<grpc.User.UserObjDTO>) responseObserver);
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

  private static abstract class UserControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserController");
    }
  }

  private static final class UserControllerFileDescriptorSupplier
      extends UserControllerBaseDescriptorSupplier {
    UserControllerFileDescriptorSupplier() {}
  }

  private static final class UserControllerMethodDescriptorSupplier
      extends UserControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserControllerFileDescriptorSupplier())
              .addMethod(getAddUserMethod())
              .addMethod(getGetUserMethod())
              .addMethod(getGetByUserAndPasswordRequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
