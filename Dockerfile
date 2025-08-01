FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline -B

COPY src/ src/

RUN ./mvnw clean package -DskipTests -B

RUN java -Djarmode=layertools -jar target/*.jar extract

FROM eclipse-temurin:17-jre-jammy

RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    curl \
    && rm -rf /var/lib/apt/lists/* \
    && groupadd -r obiwan \
    && useradd -r -g obiwan obiwan

WORKDIR /app

COPY --from=builder --chown=obiwan:obiwan app/dependencies/ ./
COPY --from=builder --chown=obiwan:obiwan app/spring-boot-loader/ ./
COPY --from=builder --chown=obiwan:obiwan app/snapshot-dependencies/ ./
COPY --from=builder --chown=obiwan:obiwan app/application/ ./

USER obiwan:obiwan

EXPOSE 8080

ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:+UseG1GC"


HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 \
    CMD curl -f http://localhost:8080/ || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS org.springframework.boot.loader.launch.JarLauncher"]