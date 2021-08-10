# Validate Password

Esse projeto foi criado com o intuito de validar uma senha passada pelo usuário, uma senha é classificada como valida caso ela respeite as seguintes regras:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto


Para efetuar essas validações foi aplicado nesse projeto o pattern [specification](https://martinfowler.com/apsupp/spec.pdf), a escolha desse pattern foi para evitar varios `ifs` encadeados, e uma melhor segregação de responsabilidade entre as verificações.

---
## Recursos

Essa aplicação possui apenas dois recursos, sendo eles: 

```
Path: /v1/validate-password

Metodo: POST

Request: {"password": ""}

Response: Boolean

Status code respose: 200 

Descrição: Recurso responsável por validar se uma senha é valida ou não
```

```
Path: /actuator

Metodo: GET

Response: JSON

Status code respose: 200

Descrição: End point do actuator onde é informado as metricas da aplicação 
```
---
## Dependências:

- [Java 11](https://sdkman.io/)
- [Maven](https://maven.apache.org/install.html)

---
## Execução local:

Comando para execução local:

```bash
./mvnw spring-boot:run
```
### Chamada de exemplo:

```
curl --location --request POST 'http://localhost:8080/v1/validate-password' \
--header 'Content-Type: application/json' \
--data-raw '{
    "password": "test"
}'
```
---
## Testes:

Para execução dos testes do projeto basta executar o comando abaixo: 

``` bash
mvn clean test
```
---
## Autor

@alaansb