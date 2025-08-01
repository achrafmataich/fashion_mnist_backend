/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

import com.github.achrafmataich.fashion_mnist_backend.grpc.FashionMNISTPredictionGrpc;

@Configuration
public class GRPCConfig {
    @Bean
    FashionMNISTPredictionGrpc.FashionMNISTPredictionBlockingStub stub(GrpcChannelFactory channels) {
        return FashionMNISTPredictionGrpc.newBlockingStub(channels.createChannel("local"));
    }
}
