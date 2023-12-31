// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/Recipe.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

public static partial class RecipeController
{
  static readonly string __ServiceName = "RecipeController";

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
  static readonly grpc::Marshaller<global::RecipeDTO> __Marshaller_RecipeDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::RecipeDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::RecipeObjDTO> __Marshaller_RecipeObjDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::RecipeObjDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::GetRecipeRequest> __Marshaller_GetRecipeRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GetRecipeRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::Empty> __Marshaller_Empty = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::Empty.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::RecipesDTO> __Marshaller_RecipesDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::RecipesDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::IdUserRequest> __Marshaller_IdUserRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::IdUserRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::GetByFilterRequest> __Marshaller_GetByFilterRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::GetByFilterRequest.Parser));

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::RecipeDTO, global::RecipeObjDTO> __Method_addRecipe = new grpc::Method<global::RecipeDTO, global::RecipeObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "addRecipe",
      __Marshaller_RecipeDTO,
      __Marshaller_RecipeObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::RecipeDTO, global::RecipeObjDTO> __Method_updateRecipe = new grpc::Method<global::RecipeDTO, global::RecipeObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "updateRecipe",
      __Marshaller_RecipeDTO,
      __Marshaller_RecipeObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::GetRecipeRequest, global::RecipeObjDTO> __Method_getRecipe = new grpc::Method<global::GetRecipeRequest, global::RecipeObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getRecipe",
      __Marshaller_GetRecipeRequest,
      __Marshaller_RecipeObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::Empty, global::RecipesDTO> __Method_getAllRecipes = new grpc::Method<global::Empty, global::RecipesDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getAllRecipes",
      __Marshaller_Empty,
      __Marshaller_RecipesDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::IdUserRequest, global::RecipesDTO> __Method_getRecipesByUserId = new grpc::Method<global::IdUserRequest, global::RecipesDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getRecipesByUserId",
      __Marshaller_IdUserRequest,
      __Marshaller_RecipesDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::GetByFilterRequest, global::RecipesDTO> __Method_getByFilter = new grpc::Method<global::GetByFilterRequest, global::RecipesDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getByFilter",
      __Marshaller_GetByFilterRequest,
      __Marshaller_RecipesDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::IdUserRequest, global::RecipesDTO> __Method_getFavotires = new grpc::Method<global::IdUserRequest, global::RecipesDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getFavotires",
      __Marshaller_IdUserRequest,
      __Marshaller_RecipesDTO);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::RecipeReflection.Descriptor.Services[0]; }
  }

  /// <summary>Client for RecipeController</summary>
  public partial class RecipeControllerClient : grpc::ClientBase<RecipeControllerClient>
  {
    /// <summary>Creates a new client for RecipeController</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public RecipeControllerClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for RecipeController that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public RecipeControllerClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected RecipeControllerClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected RecipeControllerClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO addRecipe(global::RecipeDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addRecipe(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO addRecipe(global::RecipeDTO request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_addRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> addRecipeAsync(global::RecipeDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addRecipeAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> addRecipeAsync(global::RecipeDTO request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_addRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO updateRecipe(global::RecipeDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return updateRecipe(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO updateRecipe(global::RecipeDTO request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_updateRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> updateRecipeAsync(global::RecipeDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return updateRecipeAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> updateRecipeAsync(global::RecipeDTO request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_updateRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO getRecipe(global::GetRecipeRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getRecipe(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipeObjDTO getRecipe(global::GetRecipeRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> getRecipeAsync(global::GetRecipeRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getRecipeAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipeObjDTO> getRecipeAsync(global::GetRecipeRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getRecipe, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getAllRecipes(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getAllRecipes(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getAllRecipes(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getAllRecipes, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getAllRecipesAsync(global::Empty request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getAllRecipesAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getAllRecipesAsync(global::Empty request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getAllRecipes, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getRecipesByUserId(global::IdUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getRecipesByUserId(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getRecipesByUserId(global::IdUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getRecipesByUserId, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getRecipesByUserIdAsync(global::IdUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getRecipesByUserIdAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getRecipesByUserIdAsync(global::IdUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getRecipesByUserId, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getByFilter(global::GetByFilterRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getByFilter(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getByFilter(global::GetByFilterRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getByFilter, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getByFilterAsync(global::GetByFilterRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getByFilterAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getByFilterAsync(global::GetByFilterRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getByFilter, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getFavotires(global::IdUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getFavotires(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::RecipesDTO getFavotires(global::IdUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getFavotires, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getFavotiresAsync(global::IdUserRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getFavotiresAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::RecipesDTO> getFavotiresAsync(global::IdUserRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getFavotires, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected override RecipeControllerClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new RecipeControllerClient(configuration);
    }
  }

}
#endregion
