/**
 * @author Achraf MATAICH
 */

package com.github.achrafmataich.fashion_mnist_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.grpc.client.ImportGrpcClients;

@ImportGrpcClients(basePackageClasses = FashionMnistBackendApplication.class)
@SpringBootApplication
public class FashionMnistBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionMnistBackendApplication.class, args);
	}

}