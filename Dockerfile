# --- ESTÁGIO 1: Build do Frontend (React/Vite) ---
FROM node:20-alpine AS frontend-build

WORKDIR /app-ui

# AQUI ESTAVA O ERRO: Agora copiamos de dentro da pasta 'frontend'
# Copia os arquivos de dependência
COPY frontend/package*.json ./

# Instala as dependências
RUN npm ci

# Copia todo o restante do código fonte do frontend
COPY frontend/ .

# Gera o build (cria a pasta /app-ui/dist)
RUN npm run build


# --- ESTÁGIO 2: Build do Backend (Spring Boot) ---
FROM maven:3.9-eclipse-temurin-21-alpine AS backend-build

WORKDIR /app-back

# Copia o pom.xml da pasta 'back'
COPY back/pom.xml .

# Baixa dependências (cache)
RUN mvn dependency:go-offline

# Copia o código fonte do backend
COPY back/src ./src

# --- A MÁGICA ---
# Copia o 'dist' gerado no Estágio 1 para a pasta static do Spring Boot
COPY --from=frontend-build /app-ui/dist ./src/main/resources/static/

# Gera o JAR
RUN mvn clean package -DskipTests


# --- ESTÁGIO 3: Runtime (Execução) ---
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Pega o JAR gerado no estágio 2
COPY --from=backend-build /app-back/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]