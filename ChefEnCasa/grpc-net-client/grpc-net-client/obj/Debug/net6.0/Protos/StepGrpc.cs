// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: Protos/Step.proto
// </auto-generated>
#pragma warning disable 0414, 1591, 8981, 0612
#region Designer generated code

using grpc = global::Grpc.Core;

public static partial class StepController
{
  static readonly string __ServiceName = "StepController";

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
  static readonly grpc::Marshaller<global::StepDTO> __Marshaller_StepDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::StepDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::StepObjDTO> __Marshaller_StepObjDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::StepObjDTO.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::IdRecipeRequest> __Marshaller_IdRecipeRequest = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::IdRecipeRequest.Parser));
  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Marshaller<global::StepsDTO> __Marshaller_StepsDTO = grpc::Marshallers.Create(__Helper_SerializeMessage, context => __Helper_DeserializeMessage(context, global::StepsDTO.Parser));

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::StepDTO, global::StepObjDTO> __Method_addStep = new grpc::Method<global::StepDTO, global::StepObjDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "addStep",
      __Marshaller_StepDTO,
      __Marshaller_StepObjDTO);

  [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
  static readonly grpc::Method<global::IdRecipeRequest, global::StepsDTO> __Method_getStepsByRecipeId = new grpc::Method<global::IdRecipeRequest, global::StepsDTO>(
      grpc::MethodType.Unary,
      __ServiceName,
      "getStepsByRecipeId",
      __Marshaller_IdRecipeRequest,
      __Marshaller_StepsDTO);

  /// <summary>Service descriptor</summary>
  public static global::Google.Protobuf.Reflection.ServiceDescriptor Descriptor
  {
    get { return global::StepReflection.Descriptor.Services[0]; }
  }

  /// <summary>Client for StepController</summary>
  public partial class StepControllerClient : grpc::ClientBase<StepControllerClient>
  {
    /// <summary>Creates a new client for StepController</summary>
    /// <param name="channel">The channel to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public StepControllerClient(grpc::ChannelBase channel) : base(channel)
    {
    }
    /// <summary>Creates a new client for StepController that uses a custom <c>CallInvoker</c>.</summary>
    /// <param name="callInvoker">The callInvoker to use to make remote calls.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public StepControllerClient(grpc::CallInvoker callInvoker) : base(callInvoker)
    {
    }
    /// <summary>Protected parameterless constructor to allow creation of test doubles.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected StepControllerClient() : base()
    {
    }
    /// <summary>Protected constructor to allow creation of configured clients.</summary>
    /// <param name="configuration">The client configuration.</param>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected StepControllerClient(ClientBaseConfiguration configuration) : base(configuration)
    {
    }

    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::StepObjDTO addStep(global::StepDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addStep(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::StepObjDTO addStep(global::StepDTO request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_addStep, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::StepObjDTO> addStepAsync(global::StepDTO request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return addStepAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::StepObjDTO> addStepAsync(global::StepDTO request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_addStep, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::StepsDTO getStepsByRecipeId(global::IdRecipeRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getStepsByRecipeId(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual global::StepsDTO getStepsByRecipeId(global::IdRecipeRequest request, grpc::CallOptions options)
    {
      return CallInvoker.BlockingUnaryCall(__Method_getStepsByRecipeId, null, options, request);
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::StepsDTO> getStepsByRecipeIdAsync(global::IdRecipeRequest request, grpc::Metadata headers = null, global::System.DateTime? deadline = null, global::System.Threading.CancellationToken cancellationToken = default(global::System.Threading.CancellationToken))
    {
      return getStepsByRecipeIdAsync(request, new grpc::CallOptions(headers, deadline, cancellationToken));
    }
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    public virtual grpc::AsyncUnaryCall<global::StepsDTO> getStepsByRecipeIdAsync(global::IdRecipeRequest request, grpc::CallOptions options)
    {
      return CallInvoker.AsyncUnaryCall(__Method_getStepsByRecipeId, null, options, request);
    }
    /// <summary>Creates a new instance of client from given <c>ClientBaseConfiguration</c>.</summary>
    [global::System.CodeDom.Compiler.GeneratedCode("grpc_csharp_plugin", null)]
    protected override StepControllerClient NewInstance(ClientBaseConfiguration configuration)
    {
      return new StepControllerClient(configuration);
    }
  }

}
#endregion
