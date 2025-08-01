package com.github.achrafmataich.fashion_mnist_backend.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FashionMNISTPredictionGrpc {

  private FashionMNISTPredictionGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ai.FashionMNISTPrediction";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest,
      com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> getPredictMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Predict",
      requestType = com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest.class,
      responseType = com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest,
      com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> getPredictMethod() {
    io.grpc.MethodDescriptor<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest, com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> getPredictMethod;
    if ((getPredictMethod = FashionMNISTPredictionGrpc.getPredictMethod) == null) {
      synchronized (FashionMNISTPredictionGrpc.class) {
        if ((getPredictMethod = FashionMNISTPredictionGrpc.getPredictMethod) == null) {
          FashionMNISTPredictionGrpc.getPredictMethod = getPredictMethod =
              io.grpc.MethodDescriptor.<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest, com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Predict"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply.getDefaultInstance()))
              .setSchemaDescriptor(new FashionMNISTPredictionMethodDescriptorSupplier("Predict"))
              .build();
        }
      }
    }
    return getPredictMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FashionMNISTPredictionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionStub>() {
        @java.lang.Override
        public FashionMNISTPredictionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FashionMNISTPredictionStub(channel, callOptions);
        }
      };
    return FashionMNISTPredictionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static FashionMNISTPredictionBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionBlockingV2Stub>() {
        @java.lang.Override
        public FashionMNISTPredictionBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FashionMNISTPredictionBlockingV2Stub(channel, callOptions);
        }
      };
    return FashionMNISTPredictionBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FashionMNISTPredictionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionBlockingStub>() {
        @java.lang.Override
        public FashionMNISTPredictionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FashionMNISTPredictionBlockingStub(channel, callOptions);
        }
      };
    return FashionMNISTPredictionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FashionMNISTPredictionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FashionMNISTPredictionFutureStub>() {
        @java.lang.Override
        public FashionMNISTPredictionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FashionMNISTPredictionFutureStub(channel, callOptions);
        }
      };
    return FashionMNISTPredictionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void predict(com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest request,
        io.grpc.stub.StreamObserver<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPredictMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FashionMNISTPrediction.
   */
  public static abstract class FashionMNISTPredictionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FashionMNISTPredictionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FashionMNISTPrediction.
   */
  public static final class FashionMNISTPredictionStub
      extends io.grpc.stub.AbstractAsyncStub<FashionMNISTPredictionStub> {
    private FashionMNISTPredictionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FashionMNISTPredictionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FashionMNISTPredictionStub(channel, callOptions);
    }

    /**
     */
    public void predict(com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest request,
        io.grpc.stub.StreamObserver<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPredictMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FashionMNISTPrediction.
   */
  public static final class FashionMNISTPredictionBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FashionMNISTPredictionBlockingV2Stub> {
    private FashionMNISTPredictionBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FashionMNISTPredictionBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FashionMNISTPredictionBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply predict(com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPredictMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service FashionMNISTPrediction.
   */
  public static final class FashionMNISTPredictionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FashionMNISTPredictionBlockingStub> {
    private FashionMNISTPredictionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FashionMNISTPredictionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FashionMNISTPredictionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply predict(com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPredictMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FashionMNISTPrediction.
   */
  public static final class FashionMNISTPredictionFutureStub
      extends io.grpc.stub.AbstractFutureStub<FashionMNISTPredictionFutureStub> {
    private FashionMNISTPredictionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FashionMNISTPredictionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FashionMNISTPredictionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply> predict(
        com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPredictMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PREDICT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PREDICT:
          serviceImpl.predict((com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest) request,
              (io.grpc.stub.StreamObserver<com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPredictMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest,
              com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply>(
                service, METHODID_PREDICT)))
        .build();
  }

  private static abstract class FashionMNISTPredictionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FashionMNISTPredictionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FashionMNISTPrediction");
    }
  }

  private static final class FashionMNISTPredictionFileDescriptorSupplier
      extends FashionMNISTPredictionBaseDescriptorSupplier {
    FashionMNISTPredictionFileDescriptorSupplier() {}
  }

  private static final class FashionMNISTPredictionMethodDescriptorSupplier
      extends FashionMNISTPredictionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FashionMNISTPredictionMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FashionMNISTPredictionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FashionMNISTPredictionFileDescriptorSupplier())
              .addMethod(getPredictMethod())
              .build();
        }
      }
    }
    return result;
  }
}
