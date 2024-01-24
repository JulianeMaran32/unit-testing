## Tools

* Java: version 17
* Spring Boot: version 3
* Docker: version 24.0.7
* Docker compose: version 2.24.1
* WSL (Wsman Shell commandLine): version 0.2.1
* GitHub

## Iniciando

1. Abrir o power shell como administrador
2. Executar o comando: `wsl`
3. Inicializar o docker: `sudo service docker start`
4. Build das imagens do Dockerfile: `docker build`
5. Executar o docker compose: `docker compose up -d`

---

## Instalação

* Instale o Docker e o Docker Compose no seu computador.

### Clonagem do repositório

* Clone o repositório da aplicação no seu computador.

```shell
https://github.com/JulianeMaran32/java-unit-tests.git
```

### Acesso à pasta da aplicação

* Acesse a pasta da aplicação.

```shell
cd testing-rest-api
```

## Execução

## Testes

### Construção da imagem Docker

* Execute o comando abaixo para construir a imagem Docker da aplicação.

```shell
docker build -t testing-rest-api .
```

### Inicialização dos containers Docker

* Execute o comando abaixo para iniciar os containers Docker.

```shell
docker compose up -d
```

### Executar a aplicação

```shell
docker run testing-rest-api-app
```

### Acesso à aplicação

* A aplicação estará disponível em http://localhost:8888/api.

### Testes unitários

* Os testes unitários podem ser executados utilizando o Banco de Dados H2 ou MySQL.

### Com o Banco de Dados H2

* No arquivo application.yaml da pasta src/test/java incluir a configuração:

```yaml
spring:
  url: jdbc:h2:~/testdb;DB_CLOSE_ON_EXIT=FALSE
  username: sa
  password:
  driver-class-name: org.h2.Driver
```

### Com o Banco de Dados MySQL

* No arquivo application.yaml da pasta src/test/java incluir a configuração:

```yaml
server:
  port: 8888
  servlet:
    context-path: /api

spring:
  jpa:
    open-in-view: true
    show-sql: false
    hibernate:
      ddl-auto: update
```

### Testes de integração

Os testes de integração devem ser executados apenas com o Banco de Dados MySQL.

* Execute os passos das instruções para testes unitários com o Banco de Dados MySQL.

---

# Java Unit Testing com Spring Boot 3, JUnit 5 e Mockito

## O que são Testes Unitários?

Um teste unitário é um pequeno método que você escreve para testar alguma parte do seu código.

* Exemplo:

```java
public class SimpleMath {

    public Double sum(Double firstNumber, Double secondNumber) {

        return firstNumber + secondNumber;

    }

}

class SimpleMathTest {

    @Test
    void testSum_WhenSixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {

        // Given / Arrange
        SimpleMath math = new SimpleMath();

        // When / Act
        Double actual = math.sum(6.2D, 2D);

        // Then / Assert
        assertEquals(8.2D, actual, () -> "6.2 + 2 did not produce 8.2!");

    }
}
```

* Test Reports

## Por que escrever Testes Unitários?

* Ter certeza de que o código funciona;
* O código funciona tanto com parâmetros válidos quanto inválidos ;
* O código funciona hoje e vai continuar funcionando no futuro;
* O código continuará funcionando inclusive depois que fizermos mudanças.

## Princípio FIRST

* **Fast** – os testes unitários devem executar rapidamente;
* **Independent** – os testes unitários devem ser independentes uns dos outros;
* **Repeatable** – os testes unitários devem ser repetíveis;
* **Self-validating** – os testes unitários devem se auto validarem;
* **Thorough & Timely** – os testes unitários devem cobrir casos extremos.

## Testando Código em Isolado

* Testando Código em Isolado
* Injeção de Dependências

## Pirâmide de Testes

1. **Unit Tests** (base da pirâmide): testes de pequenos trechosde código isolados com dependências stubs ou mockadas.
2. **Integration Tests**: o código da aplicação é testado sem mockar acessos ao banco de dados e/ou conexões HTTP
3. **End-to-end Testing / UI Testing** (topo da pirâmide): Testes de funcionalidade de softeware de ponta a ponta

## O que é JUnit 5?

JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

* **JUnit Platform**: A plataforma JUnit é o principal framework para testes na JVM, sendo a base que fundamenta a
  maioria das novas ferramentas de testes;
* **JUnit Jupiter**: É a combinação do novo modelo de programação e extensão para escrever testes e extensões para o
  JUnit 5;
* **JUnit Vintage**: TestEngine de backward compatibility para a execução de testes escritos em JUnit 3 e JUnit 4

## JUnit e Ferramentas de Build

* IDEs:
    * Spring Tool Suite (STS)
    * Eclipse
    * IntelliJ IDEA
    * NetBeans
    * Visual Studio Code (VSCode)
* Ferramentas de Build:
    * Maven
    * Gradle
    * Ant

## Ciclo de Vida dos Testes no JUnit 5

```java
class SimpleMathTest {

    @Test
    void testSum() {

        SimpleMath math = new SimpleMath();
        Double actual = math.sum(6.2D, 2D);
        assertEquals(8.2D, actual);

    }

}
```

* Annotations:
    * `@Test`
    * `@BeforeAll`
    * `@BeforeEach`
    * `@AfterEach`
    * `@AfterAll`

## Introdução ao Ciclo de Vida do Test Instance

* Por padrão, o ciclo de vida da instância de testes é "por método“;
* A ordem de execução é determinística, mas intencionalmente não óbvia.
* `@TestInstance(Lifecycle.PER_CLASS)`

## Test Driven Development - TDD

### Ciclo de Vida dos Testes no JUnit 5

1. RED: write a test, watch it fail.
2. GREEN: write just enough code to pass the test.
3. REFACTOR: improve the code without changing its behavior

## Annotation `@DataJpaTest` do Spring Boot

### Testando a Camada de Repositórios de uma aplicação Spring Boot

`@DataJpaTest` Annotation

* O Spring Boot fornece a anotação `@DataJpaTest` para testar os componentes da camada de persistência, que configurarão
  automaticamente um banco de dados embarcado em memória para fins de teste;
* A anotação `@DataJpaTest` não carrega outros beans do Spring (`@Components`, `@Controller`, `@Service` e beans
  anotados) no `ApplicationContext`;
* Por padrão, ele procura por classes `@Entity` e configura os repositórios do Spring Data JPA anotados com a
  anotação `@Repository`;
* Por padrão, os testes anotados com `@DataJpaTest` são transacionais e são revertidos ao final de cada teste;
* Para testar repositórios do Spring Data JPA ou qualquer outro componente relacionado ao JPA, o Spring Boot fornece a
  anotação `@DataJpaTest`;

```java

@DataJpaTest
class PersonRepositoryTest {

}
```

## Overview e as Annotations `@Mock` e `@InjectMocks` do Mockito

Testando a Camada de Serviços de uma aplicação Spring Boot

### Mockito `@InjectMocks` Annotations

* Quando queremos injetar um objeto mockado em outro objeto mockado, podemos usar a annotation `@InjectMocks`. A
  annotation `@InjectMocks` cria um mock da classe e injeta os mocks que estão marcados com as annotations `@Mock` nela

```java

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    PersonService service;

    @Mock
    PersonRepository repository;

}
```

## Overview do Teste de Controller e Annotation `@WebMvcTest`

Testando a Camada de Controllers de uma aplicação Spring Boot

### JsonPath Library

* Uma DSL Java para leitura de documentos JSON.
* As expressões `JsonPath` sempre se referem a uma estrutura JSON da mesma forma que as expressões XPath são usadas em
  combinação com um documento XML. O "objeto membro raiz" no JsonPath é sempre referido como $, independentemente de ser
  um objeto ou um array.

#### JSON

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
```

#### JsonPath Expressions

- root member de uma estrutura JSON, seja um objeto ou um array

```
$ - root member de uma estrutura JSON, seja um objeto ou um array
$.firtName = "John",
$.lastName = "Doe",
$.email = "john.doe@example.com",
```

## `@WebMvcTest` vs `@SpringBootTest`

### `@WebMvcTest` Annotation

* O Spring Boot fornece a anotação `@WebMvcTest` para testar controllers Spring MVC. Além disso, os testes baseados
  em `@WebMvcTest` são mais rápidos, pois carregam apenas o controller especificado e suas dependências, sem carregar a
  aplicação inteira;
* O Spring Boot instancia apenas a camada web em vez de todo o application context. Em uma aplicação com vários
  controllers, você pode definir a instanciação de apenas um deles usando, por
  exemplo, `@WebMvcTest(PersonController.class)`.

### `@WebMvcTest` vs `@SpringBootTest`

* O Spring Boot fornece a anotação `@WebMvcTest` para testar controllers do Spring MVC. Essa anotação cria um
  application context que contém todos os beans necessários para testar um controlador web do Spring;
* O Spring Boot fornece a anotação `@SpringBootTest` para testes de integração. Essa anotação carrega um application
  context completo;
* Teste de unidade - anotação `@WebMvcTest`;
* Teste de integração - anotação `@SpringBootTest`

> A diferença entre `@WebMvcTest` e `@SpringBootTest` é que o primeiro é usado para testar apenas a camada web da
> aplicação, enquanto o segundo é usado para testar a aplicação inteira. O `@WebMvcTest` é mais rápido, pois cria um
> contexto de aplicação com um número limitado de beans, especificamente aqueles relacionados à camada web. Já
> o `@SpringBootTest` inicia o contexto completo da aplicação, incluindo todos os beans necessários para a aplicação
> funcionar.

## Integration Testing e `@SpringBootTest` Annotation Overview

Testes de Integração em uma aplicação Spring Boot

* Como o nome sugere, os testes de integração têm foco na integração de diferentes camadas da aplicação. Isso também
  significa que não há uso de mocks;
* Basicamente, escrevemos testes de integração para testar um features que podem envolver interação com múltiplos
  componentes.

### `@SpringBootTest` Annotation

* O Spring Boot fornece a anotação `@SpringBootTest` para testes de integração. Essa anotação cria um application
  context completo.
* `@SpringBootTest` inicializará o application context completo, o que significa que podemos usar a anotação `@Autowire`
  para injetar qualquer bean detectado pelo component scan em nosso teste.
* Testes de integração - `@SpringBootTest`
* Ele inicializa um servidor embarcado, cria um web environment e possibilita que os métodos `@Test` façam testes de
  integração
* Por padrão, `@SpringBootTest` não inicia um servidor. Precisamos adicionar o atributo `WebEnvironment` para refinar
  ainda mais como nossos testes serão executados. Existem várias opções:
    * **MOCK (Padrão)**: Carrega um `WebServerApplicationContext` e fornece um web environment mockado;
    * **RANDOM_PORT**: Carrega um `WebServerApplicationContext` e fornece um web environment real. O servidor embarcado
      é iniciado e exposto em uma porta aleatória. Essa opção deve ser usada para testes de integração;
    * **DEFINED_PORT**: Carrega um `WebServerApplicationContext` e fornece um web environment real;
    * **NONE**: Carrega um `ApplicationContext` usando o `SpringApplication`, mas não fornece nenhum web environment.

Acessar o Swagger via Navegador: http://localhost:8080/api/swagger-ui/index.html

---

## Referências

### GitHub

* [Leandro CGSI - Automated Tests with Java Erudio](https://github.com/leandrocgsi/automated-tests-with-java-erudio)





