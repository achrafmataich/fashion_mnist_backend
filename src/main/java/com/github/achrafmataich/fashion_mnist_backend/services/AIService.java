/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend.services;

import org.springframework.stereotype.Service;

import com.github.achrafmataich.fashion_mnist_backend.grpc.FashionMNISTPredictionGrpc;
import com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.ImageRequest;
import com.github.achrafmataich.fashion_mnist_backend.grpc.Ai.PredictionReply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIService {
    private final FashionMNISTPredictionGrpc.FashionMNISTPredictionBlockingStub stub;

    public String predictImage(final String base64Image) {
        final PredictionReply reply = stub.predict(ImageRequest.newBuilder().setImage(base64Image).build());
        return reply.getPrediction();
    }
}
