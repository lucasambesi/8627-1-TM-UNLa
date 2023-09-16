// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/User.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

public static partial class UserController
{
  static readonly string __ServiceName = "UserController";

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static void __Helper_SerializeMessage(global::Google.Protobuf.IMessage message, grpc::SerializationContext context)
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (message is global::Google.Protobuf.IBufferMessage)
    {
      context.SetPayloadLength(message.CalculateSize());
      global::Google.Protobuf.MessageExtensions.WriteTo(message, context.GetBufferWriter());
      context.Complete();
      return;
    }
    #endif
    context.Complete(global::Google.Protobuf.MessageExtensions.ToByteArray(message));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static class __Helper_MessageCache<T>
  {
    public static readonly bool IsBufferMessage = global::System.Reflection.IntrospectionExtensions.GetTypeInfo(typeof(global::Google.Protobuf.IBufferMessage)).IsAssignableFrom(typeof(T));
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static T __Helper_DeserializeMessage<T>(grpc::DeserializationContext context, global::Google.Protobuf.MessageParser<T> parser) where T : global::Google.Protobuf.IMessage<T>
  {
    #if !GRPC_DISABLE_PROTOBUF_BUFFER_SERIALIZATION
    if (__Helper_MessageCache<T>.IsBufferMessage)
    {
      return parser.ParseFrom(context.PayloadAsReadOnlySequence());
    }
    #endif
    return parser.ParseFrom(context.PayloadAsNewBuffer());
  }

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::UserDTO> __Marshaller_UserDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::UserDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::UserObjDTO> __Marshaller_UserObjDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::UserObjDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PostFollowingRequest> __Marshaller_PostFollowingRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PostFollowingRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PostFollowingResponse> __Marshaller_PostFollowingResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PostFollowingResponse.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::GetUserRequest> __Marshaller_GetUserRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GetUserRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::UsersDTO> __Marshaller_UsersDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::UsersDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::GetByUserIdAndPasswordRequest> __Marshaller_GetByUserIdAndPasswordRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GetByUserIdAndPasswordRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PostFavoriteRequest> __Marshaller_PostFavoriteRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PostFavoriteRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::PostFavoriteResponse> __Marshaller_PostFavoriteResponse = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::PostFavoriteResponse.Parser));

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::UserDTO, global::UserObjDTO> __Method_addUser = new grpc::Method<global::UserDTO, global::UserObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "addUser",
      __Marshaller_UserDTO,
      __Marshaller_UserObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PostFollowingRequest, global::PostFollowingResponse> __Method_addFollowing = new grpc::Method<global::PostFollowingRequest, global::PostFollowingResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "addFollowing",
      __Marshaller_PostFollowingRequest,
      __Marshaller_PostFollowingResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::GetUserRequest, global::UsersDTO> __Method_getFollowings = new grpc::Method<global::GetUserRequest, global::UsersDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getFollowings",
      __Marshaller_GetUserRequest,
      __Marshaller_UsersDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::GetUserRequest, global::UserObjDTO> __Method_getUser = new grpc::Method<global::GetUserRequest, global::UserObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getUser",
      __Marshaller_GetUserRequest,
      __Marshaller_UserObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::GetByUserIdAndPasswordRequest, global::UserObjDTO> __Method_getByUserAndPasswordRequest = new grpc::Method<global::GetByUserIdAndPasswordRequest, global::UserObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getByUserAndPasswordRequest",
      __Marshaller_GetByUserIdAndPasswordRequest,
      __Marshaller_UserObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PostFavoriteRequest, global::PostFavoriteResponse> __Method_addFavorite = new grpc::Method<global::PostFavoriteRequest, global::PostFavoriteResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "addFavorite",
      __Marshaller_PostFavoriteRequest,
      __Marshaller_PostFavoriteResponse);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::PostFavoriteRequest, global::PostFavoriteResponse> __Method_deleteFavorite = new grpc::Method<global::PostFavoriteRequest, global::PostFavoriteResponse>(
      grpc::MethodType.Unary,
      __ServiceName,
      "deleteFavorite",
      __Marshaller_PostFavoriteRequest,
      __Marshaller_PostFavoriteResponse);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::UserReflection.Descriptor.Services[0]; }
  }

  /// <summary>Client for UserController</summary>
  public partial class UserControllerClient : grpc::ClientBase<UserControllerClient>
  {
    /// <summary>Creates a new client for UserController</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public UserControllerClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for UserController that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public UserControllerClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected UserControllerClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected UserControllerClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO addUser(global::UserDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addUser(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO addUser(global::UserDTO request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_addUser, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> addUserAsync(global::UserDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addUserAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> addUserAsync(global::UserDTO request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_addUser, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFollowingResponse addFollowing(global::PostFollowingRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addFollowing(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFollowingResponse addFollowing(global::PostFollowingRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_addFollowing, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFollowingResponse> addFollowingAsync(global::PostFollowingRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addFollowingAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFollowingResponse> addFollowingAsync(global::PostFollowingRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_addFollowing, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UsersDTO getFollowings(global::GetUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getFollowings(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UsersDTO getFollowings(global::GetUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getFollowings, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UsersDTO> getFollowingsAsync(global::GetUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getFollowingsAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UsersDTO> getFollowingsAsync(global::GetUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getFollowings, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO getUser(global::GetUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getUser(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO getUser(global::GetUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getUser, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> getUserAsync(global::GetUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getUserAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> getUserAsync(global::GetUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getUser, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO getByUserAndPasswordRequest(global::GetByUserIdAndPasswordRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getByUserAndPasswordRequest(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::UserObjDTO getByUserAndPasswordRequest(global::GetByUserIdAndPasswordRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getByUserAndPasswordRequest, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> getByUserAndPasswordRequestAsync(global::GetByUserIdAndPasswordRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getByUserAndPasswordRequestAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::UserObjDTO> getByUserAndPasswordRequestAsync(global::GetByUserIdAndPasswordRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getByUserAndPasswordRequest, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFavoriteResponse addFavorite(global::PostFavoriteRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addFavorite(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFavoriteResponse addFavorite(global::PostFavoriteRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_addFavorite, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFavoriteResponse> addFavoriteAsync(global::PostFavoriteRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addFavoriteAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFavoriteResponse> addFavoriteAsync(global::PostFavoriteRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_addFavorite, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFavoriteResponse deleteFavorite(global::PostFavoriteRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return deleteFavorite(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::PostFavoriteResponse deleteFavorite(global::PostFavoriteRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_deleteFavorite, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFavoriteResponse> deleteFavoriteAsync(global::PostFavoriteRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return deleteFavoriteAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::PostFavoriteResponse> deleteFavoriteAsync(global::PostFavoriteRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_deleteFavorite, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected override UserControllerClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new UserControllerClient(configuration);
    }
  }

}
#endregion
