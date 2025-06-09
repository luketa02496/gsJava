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

# Criar um grupo e usuário não-root
RUN groupadd --system appgroup && useradd --system --gid appgroup appuser

WORKDIR /app

# Copiar o arquivo jar gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Definir o usuário para executar a aplicação
USER appuser

# Expor a porta 8080
EXPOSE 8080

# Adicionar uma variável de ambiente de exemplo
ENV APP_ENV=production

# Comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]