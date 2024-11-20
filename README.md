<h1 align="center">
  Access Token Pattern com KeyCloak
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Tutorial&color=8257E5&labelColor=000000" alt="Tutorial" />
</p>

Este projeto demonstra o uso do access token pattern com Spring Boot e Spring Cloud Gateway.

Contém três projetos interconectados que compõem um sistema distribuído: **Integrador Main**, **Gateway**, e **Resource Server**. Esses projetos trabalham em conjunto para garantir a integração, o roteamento e a segurança de toda a aplicação.

# Tabela de Conteúdos

- [Integrador (main)](#integrador-main)
- [Gateway](#gateway)
- [Resource Server](#resource-server)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Configuração do Projeto](#configuração-do-projeto)
- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Execução](#execução)
- [Testes](#testes)
- [Licença](#licença)
- [Autores](#autores)

## Integrador (main)

### Descrição

O **Integrador (main)** atua como um elo de integração, responsável por interconectar diferentes sistemas e serviços, facilitando a coordenação e o fluxo de informações entre eles. Ele é essencial para a orquestração de processos empresariais complexos, garantindo que diferentes componentes do sistema possam funcionar de maneira coesa.

## Gateway

### Descrição

O **Gateway** é responsável por gerenciar todas as requisições que chegam ao sistema, atuando como um ponto central de entrada para diferentes serviços e subsistemas. Ele emprega o padrão API Gateway, que permite roteamento de requisições, balanceamento de carga, autenticação e autorização, e mais.

## Resource Server

### Descrição

O **Resource Server** é um servidor de recursos baseado em Spring Boot, configurado para atuar com OAuth2 para autenticação e autorização. Esse servidor tem o papel de proteger recursos e dados sensíveis, garantindo que apenas usuários autenticados e autorizados possam acessá-los.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
    - Spring Integration
    - Spring Cloud Gateway
    - Spring Security (OAuth2)
    - Spring Boot DevTools
    - Spring Boot Starter Web
    - Spring Boot Starter Test
- **Maven**

## Configuração do Projeto

Os projetos estão configurados utilizando o Maven como gerenciador de dependências. As dependências principais incluem:

- **Spring Integration**: Utilizado no Integrador Main para orquestração e integração de sistemas.
- **Spring Cloud Gateway**: Utilizado no Gateway para roteamento e outras funcionalidades de gateway.
- **Spring Security OAuth2**: Utilizado no Resource Server para garantir segurança.
- **Spring Boot Starter Web**: Utilizado em todos os projetos para criar aplicações web.
- **Spring Boot DevTools**: Facilita o desenvolvimento, oferecendo ferramentas como live reload.
- **Spring Boot Starter Test**: Inclui dependências necessárias para testes unitários e de integração.

## Requisitos

Para compilar e executar os projetos, os seguintes itens são necessários:

- **JDK** (versão adequada ao Spring Boot utilizado)
- **Maven** (versão 3.6.0 ou superior)

## Configuração do Keycloak

1 - Executar Keycloak
```
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.5 start-dev
```

2 - Criar um realm

3 - Criar usuário e client oauth no Keycloak

4 - Ajustar as propriedades do gateway para apontar para o realm e client cadastrados

5 - Executar projetos gateway e resource-server

## Instalação

1. **Clone os repositórios:**
   ```sh
   git clone https://github.com/wagnerdba/integrador-main.git
   git clone https://github.com/wagnerdba/gateway.git
   git clone https://github.com/wagnerdba/resource-server.git
   ```

2. **Compilar os projetos utilizando Maven:**
   ```sh
   cd integrador-main && mvn clean install
   cd ../gateway && mvn clean install
   cd ../resource-server && mvn clean install
   ```

## Execução

Para executar os projetos, utilize os seguintes comandos Maven:

```sh
cd integrador-main
mvn spring-boot:run

cd ../gateway
mvn spring-boot:run

cd ../resource-server
mvn spring-boot:run
```

## Licença

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Autores

- **Nome do Desenvolvedor** - *Wagner Pires* - [GitHub](https://github.com/wagnerdba)

## Testando a Aplicação

Será possível acessar uma rota protegida através do gateway em [http://localhost:9001/api/hello](http://localhost:9000/api/hello):

- GET /hello: Rota que pede autenticação