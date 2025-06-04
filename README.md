# 🌐 SAFE.Core – API de Monitoramento de Temperaturas Extremas

Sistema desenvolvido como parte da **Global Solution** com o objetivo de prevenir riscos causados por temperaturas extremas em regiões vulneráveis. A aplicação consiste em uma API RESTful construída em **Java Spring Boot**, conectada a um banco de dados Oracle, com autenticação via **JWT**, documentação via **Swagger**, e endpoints para gerenciamento de sensores, leituras, alertas e regiões.

---

## 🧠 Visão Geral da Solução

A solução **SAFE.Guard** é composta por três camadas:

- **SAFE.Core** (esta API): recebe e processa os dados de sensores ambientais.
- **SAFE.Dashboard**: painel web para visualização de alertas e análises.
- **SAFE.App**: aplicativo mobile para notificação e orientação da população.

### Funcionalidades da API:

- CRUD de **Regiões**, **Sensores**, **Leituras** e **Alertas**
- Relatórios como:
  - Temperatura média por região
  - Geração automática de alertas com base em leituras
- Autenticação com **JWT**
- Documentação com **Swagger**
- Banco de dados Oracle

---

## 🚀 Como Executar o Projeto Localmente

### ✅ Pré-requisitos

- Java 17 ou superior
- Maven 3.8+
- Oracle Database (acesso ao banco da FIAP ou local)
- IDE (IntelliJ ou Eclipse)

## Link Do Swagger
http://localhost:8080/swagger-ui/index.html
