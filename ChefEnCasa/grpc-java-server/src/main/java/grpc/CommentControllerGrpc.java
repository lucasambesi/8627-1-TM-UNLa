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
    comments = "Source: Comment.proto")
public final class CommentControllerGrpc {

  private CommentControllerGrpc() {}

  public static final String SERVICE_NAME = "CommentController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Comment.GetCommentRequest,
      grpc.Comment.CommentsDTO> getGetCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getComments",
      requestType = grpc.Comment.GetCommentRequest.class,
      responseType = grpc.Comment.CommentsDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Comment.GetCommentRequest,
      grpc.Comment.CommentsDTO> getGetCommentsMethod() {
    io.grpc.MethodDescriptor<grpc.Comment.GetCommentRequest, grpc.Comment.CommentsDTO> getGetCommentsMethod;
    if ((getGetCommentsMethod = CommentControllerGrpc.getGetCommentsMethod) == null) {
      synchronized (CommentControllerGrpc.class) {
        if ((getGetCommentsMethod = CommentControllerGrpc.getGetCommentsMethod) == null) {
          CommentControllerGrpc.getGetCommentsMethod = getGetCommentsMethod = 
              io.grpc.MethodDescriptor.<grpc.Comment.GetCommentRequest, grpc.Comment.CommentsDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CommentController", "getComments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Comment.GetCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Comment.CommentsDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new CommentControllerMethodDescriptorSupplier("getComments"))
                  .build();
          }
        }
     }
     return getGetCommentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommentControllerStub newStub(io.grpc.Channel channel) {
    return new CommentControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommentControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CommentControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommentControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CommentControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class CommentControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void getComments(grpc.Comment.GetCommentRequest request,
        io.grpc.stub.StreamObserver<grpc.Comment.CommentsDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCommentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCommentsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Comment.GetCommentRequest,
                grpc.Comment.CommentsDTO>(
                  this, METHODID_GET_COMMENTS)))
          .build();
    }
  }

  /**
   */
  public static final class CommentControllerStub extends io.grpc.stub.AbstractStub<CommentControllerStub> {
    private CommentControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommentControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommentControllerStub(channel, callOptions);
    }

    /**
     */
    public void getComments(grpc.Comment.GetCommentRequest request,
        io.grpc.stub.StreamObserver<grpc.Comment.CommentsDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCommentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommentControllerBlockingStub extends io.grpc.stub.AbstractStub<CommentControllerBlockingStub> {
    private CommentControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommentControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommentControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Comment.CommentsDTO getComments(grpc.Comment.GetCommentRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCommentsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommentControllerFutureStub extends io.grpc.stub.AbstractStub<CommentControllerFutureStub> {
    private CommentControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CommentControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CommentControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Comment.CommentsDTO> getComments(
        grpc.Comment.GetCommentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCommentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COMMENTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommentControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommentControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMMENTS:
          serviceImpl.getComments((grpc.Comment.GetCommentRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Comment.CommentsDTO>) responseObserver);
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

  private static abstract class CommentControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommentControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Comment.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommentController");
    }
  }

  private static final class CommentControllerFileDescriptorSupplier
      extends CommentControllerBaseDescriptorSupplier {
    CommentControllerFileDescriptorSupplier() {}
  }

  private static final class CommentControllerMethodDescriptorSupplier
      extends CommentControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommentControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommentControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommentControllerFileDescriptorSupplier())
              .addMethod(getGetCommentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
