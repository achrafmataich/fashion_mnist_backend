# Fashion MNIST Web Application Backend

This repository contains a Spring Boot web application that provides a user-friendly interface for Fashion MNIST image classification. The backend communicates with an AI model server via gRPC protocol to deliver real-time predictions through an elegant web interface.

This project shows modern web development practices by integrating artificial intelligence into a traditional web application using Spring Boot, Thymeleaf, and gRPC communication.

## Getting Started

To run this application, ensure you have Java 17 or newer installed on your system. You can verify your Java installation by running:

```bash
java -version
```

The application uses Maven as its build tool, so you can start the server using the included Maven wrapper without needing to install Maven separately:

```bash
./mvnw spring-boot:run
```

For Windows users, use the batch file instead:

```bash
mvnw.cmd spring-boot:run
```

## Building the Application

If you prefer to build the application first and then run the generated JAR file, you can do so with these commands:

```bash
./mvnw clean package
java -jar target/fashion_mnist_backend-0.0.1-SNAPSHOT.jar
```

## Docker Support

The application can also be containerized for easy deployment. Build the Docker image using:

```bash
docker build -t fashion-mnist-backend .
```

Then run the container with:

```bash
docker run -p 8080:8080 fashion-mnist-backend
```

When running in containerized environments, you can configure the gRPC server address using environment variables:

```bash
docker run -p 8080:8080 -e FASHION_MNIST_GRPC_ADDRESS=grpc-server:5050 fashion-mnist-backend
```

Replace `grpc-server:5050` with your actual gRPC server hostname and port. This is particularly useful when deploying with Docker Compose or Kubernetes where services communicate using service names rather than localhost.

> Make sure both containers are in the same docker bridged network

## Application Features

Once the application is running, navigate to `http://localhost:8080` in your web browser. The application provides an intuitive interface where users can upload fashion item images and receive instant AI-powered classifications.

Supported image formats include JPEG and PNG files up to 5MB in size.

> **Important:** For best results, use images from the Fashion MNIST dataset or simple clothing items photographed against a plain dark background without models wearing them. The AI model is specifically trained on Fashion MNIST data and performs optimally with similar image characteristics.

## gRPC Integration

This backend application communicates with a separate [AI model server](https://github.com/achrafmataich/fashion_mnist_ai_model) via gRPC protocol. Make sure you have the Fashion MNIST AI model server running on port 5050 before starting this web application. The gRPC integration handles the heavy computational work of image classification while this backend focuses on providing a smooth user experience.

## Technology Stack

The application is built using Spring Boot with Java 17.

## Development

For development purposes, the Spring gRPC plugin automatically generates Java classes from the protobuf definitions. These generated files are initially placed in the `target/generated-sources/` directory.

To avoid adding the target directory to your IDE's classpath, you should move the generated gRPC files to the appropriate package in your `src/main/java/` directory after the first build:

```bash
./mvnw clean compile
```

This ensures your IDE can properly resolve the gRPC classes without additional classpath configuration. The generated files include the service stubs and message classes needed for gRPC communication.

## References

For more information about Spring Boot, visit the official documentation at https://spring.io/projects/spring-boot.

To learn more about gRPC integration with Spring Boot, see the Spring gRPC documentation at https://github.com/grpc-ecosystem/grpc-spring.

For setting up Tailwind CSS in Spring Boot applications, follow the comprehensive guide at https://wanderlytics.me/posts/3/how-to-add-tailwind-css-in-spring-boot-application.

For Fashion MNIST dataset information, refer to the official documentation at https://pytorch.org/vision/stable/generated/torchvision.datasets.FashionMNIST.html.

## Author

<img src="https://avatars.githubusercontent.com/u/100163733?size=128" alt="Achraf MATAICH" width="64" height="64" style="border-radius: 50%;">

Achraf MATAICH <achraf.mataich@outlook.com>
