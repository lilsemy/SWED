FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY src/ ./src/

RUN mkdir -p bin && javac -d bin $(find src -name "*.java")

ENTRYPOINT ["java", "-cp", "bin", "Main"]
