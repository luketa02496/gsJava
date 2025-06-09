# Etapa de build
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Build do projeto (compilar e empacotar)
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiar o arquivo jar gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]


# Criar usuário não-root
RUN useradd -m appuser

# Mudar para esse usuário
USER appuser
