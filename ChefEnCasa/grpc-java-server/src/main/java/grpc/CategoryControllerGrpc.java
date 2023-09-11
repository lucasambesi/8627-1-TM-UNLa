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
    comments = "Source: Category.proto")
public final class CategoryControllerGrpc {

  private CategoryControllerGrpc() {}

  public static final String SERVICE_NAME = "CategoryController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Category.CategoryDTO,
      grpc.Category.CategoryObjDTO> getAddCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addCategory",
      requestType = grpc.Category.CategoryDTO.class,
      responseType = grpc.Category.CategoryObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Category.CategoryDTO,
      grpc.Category.CategoryObjDTO> getAddCategoryMethod() {
    io.grpc.MethodDescriptor<grpc.Category.CategoryDTO, grpc.Category.CategoryObjDTO> getAddCategoryMethod;
    if ((getAddCategoryMethod = CategoryControllerGrpc.getAddCategoryMethod) == null) {
      synchronized (CategoryControllerGrpc.class) {
        if ((getAddCategoryMethod = CategoryControllerGrpc.getAddCategoryMethod) == null) {
          CategoryControllerGrpc.getAddCategoryMethod = getAddCategoryMethod = 
              io.grpc.MethodDescriptor.<grpc.Category.CategoryDTO, grpc.Category.CategoryObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CategoryController", "addCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.CategoryDTO.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.CategoryObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryControllerMethodDescriptorSupplier("addCategory"))
                  .build();
          }
        }
     }
     return getAddCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Category.GetCategoryRequest,
      grpc.Category.CategoryObjDTO> getGetCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCategory",
      requestType = grpc.Category.GetCategoryRequest.class,
      responseType = grpc.Category.CategoryObjDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Category.GetCategoryRequest,
      grpc.Category.CategoryObjDTO> getGetCategoryMethod() {
    io.grpc.MethodDescriptor<grpc.Category.GetCategoryRequest, grpc.Category.CategoryObjDTO> getGetCategoryMethod;
    if ((getGetCategoryMethod = CategoryControllerGrpc.getGetCategoryMethod) == null) {
      synchronized (CategoryControllerGrpc.class) {
        if ((getGetCategoryMethod = CategoryControllerGrpc.getGetCategoryMethod) == null) {
          CategoryControllerGrpc.getGetCategoryMethod = getGetCategoryMethod = 
              io.grpc.MethodDescriptor.<grpc.Category.GetCategoryRequest, grpc.Category.CategoryObjDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CategoryController", "getCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.GetCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.CategoryObjDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryControllerMethodDescriptorSupplier("getCategory"))
                  .build();
          }
        }
     }
     return getGetCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Category.EmptyCategory,
      grpc.Category.CategoriesDTO> getGetAllCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCategories",
      requestType = grpc.Category.EmptyCategory.class,
      responseType = grpc.Category.CategoriesDTO.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Category.EmptyCategory,
      grpc.Category.CategoriesDTO> getGetAllCategoriesMethod() {
    io.grpc.MethodDescriptor<grpc.Category.EmptyCategory, grpc.Category.CategoriesDTO> getGetAllCategoriesMethod;
    if ((getGetAllCategoriesMethod = CategoryControllerGrpc.getGetAllCategoriesMethod) == null) {
      synchronized (CategoryControllerGrpc.class) {
        if ((getGetAllCategoriesMethod = CategoryControllerGrpc.getGetAllCategoriesMethod) == null) {
          CategoryControllerGrpc.getGetAllCategoriesMethod = getGetAllCategoriesMethod = 
              io.grpc.MethodDescriptor.<grpc.Category.EmptyCategory, grpc.Category.CategoriesDTO>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CategoryController", "getAllCategories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.EmptyCategory.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Category.CategoriesDTO.getDefaultInstance()))
                  .setSchemaDescriptor(new CategoryControllerMethodDescriptorSupplier("getAllCategories"))
                  .build();
          }
        }
     }
     return getGetAllCategoriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoryControllerStub newStub(io.grpc.Channel channel) {
    return new CategoryControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoryControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CategoryControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoryControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CategoryControllerFutureStub(channel);
  }

  /**
   */
  public static abstract class CategoryControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void addCategory(grpc.Category.CategoryDTO request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getAddCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getCategory(grpc.Category.GetCategoryRequest request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCategoryMethod(), responseObserver);
    }

    /**
     */
    public void getAllCategories(grpc.Category.EmptyCategory request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoriesDTO> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllCategoriesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Category.CategoryDTO,
                grpc.Category.CategoryObjDTO>(
                  this, METHODID_ADD_CATEGORY)))
          .addMethod(
            getGetCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Category.GetCategoryRequest,
                grpc.Category.CategoryObjDTO>(
                  this, METHODID_GET_CATEGORY)))
          .addMethod(
            getGetAllCategoriesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Category.EmptyCategory,
                grpc.Category.CategoriesDTO>(
                  this, METHODID_GET_ALL_CATEGORIES)))
          .build();
    }
  }

  /**
   */
  public static final class CategoryControllerStub extends io.grpc.stub.AbstractStub<CategoryControllerStub> {
    private CategoryControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryControllerStub(channel, callOptions);
    }

    /**
     */
    public void addCategory(grpc.Category.CategoryDTO request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCategory(grpc.Category.GetCategoryRequest request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCategories(grpc.Category.EmptyCategory request,
        io.grpc.stub.StreamObserver<grpc.Category.CategoriesDTO> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CategoryControllerBlockingStub extends io.grpc.stub.AbstractStub<CategoryControllerBlockingStub> {
    private CategoryControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.Category.CategoryObjDTO addCategory(grpc.Category.CategoryDTO request) {
      return blockingUnaryCall(
          getChannel(), getAddCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Category.CategoryObjDTO getCategory(grpc.Category.GetCategoryRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Category.CategoriesDTO getAllCategories(grpc.Category.EmptyCategory request) {
      return blockingUnaryCall(
          getChannel(), getGetAllCategoriesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CategoryControllerFutureStub extends io.grpc.stub.AbstractStub<CategoryControllerFutureStub> {
    private CategoryControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CategoryControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CategoryControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Category.CategoryObjDTO> addCategory(
        grpc.Category.CategoryDTO request) {
      return futureUnaryCall(
          getChannel().newCall(getAddCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Category.CategoryObjDTO> getCategory(
        grpc.Category.GetCategoryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Category.CategoriesDTO> getAllCategories(
        grpc.Category.EmptyCategory request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllCategoriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CATEGORY = 0;
  private static final int METHODID_GET_CATEGORY = 1;
  private static final int METHODID_GET_ALL_CATEGORIES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CategoryControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CategoryControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CATEGORY:
          serviceImpl.addCategory((grpc.Category.CategoryDTO) request,
              (io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO>) responseObserver);
          break;
        case METHODID_GET_CATEGORY:
          serviceImpl.getCategory((grpc.Category.GetCategoryRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Category.CategoryObjDTO>) responseObserver);
          break;
        case METHODID_GET_ALL_CATEGORIES:
          serviceImpl.getAllCategories((grpc.Category.EmptyCategory) request,
              (io.grpc.stub.StreamObserver<grpc.Category.CategoriesDTO>) responseObserver);
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

  private static abstract class CategoryControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CategoryControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Category.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CategoryController");
    }
  }

  private static final class CategoryControllerFileDescriptorSupplier
      extends CategoryControllerBaseDescriptorSupplier {
    CategoryControllerFileDescriptorSupplier() {}
  }

  private static final class CategoryControllerMethodDescriptorSupplier
      extends CategoryControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CategoryControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (CategoryControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoryControllerFileDescriptorSupplier())
              .addMethod(getAddCategoryMethod())
              .addMethod(getGetCategoryMethod())
              .addMethod(getGetAllCategoriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
