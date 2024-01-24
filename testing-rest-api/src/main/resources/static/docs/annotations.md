## Annotaions

**@Test**

A anotação `@Test` indica que um método é um teste. Os testes são usados para verificar se o código está funcionando
corretamente.

**@BeforeAll**

A anotação `@BeforeAll` indica que um método deve ser executado antes de todos os testes em uma classe. Este método é
útil para configurar a infraestrutura de teste, como inicializar um banco de dados ou carregar dados de teste.

**@BeforeEach**

A anotação `@BeforeEach` indica que um método deve ser executado antes de cada teste em uma classe. Este método é útil
para configurar o estado do teste, como criar objetos ou preencher campos.

**@AfterEach**

A anotação `@AfterEach` indica que um método deve ser executado após cada teste em uma classe. Este método é útil para
limpar o estado do teste, como fechar conexões com o banco de dados ou remover objetos criados.

**@AfterAll**

A anotação `@AfterAll` indica que um método deve ser executado após todos os testes em uma classe. Este método é útil
para limpar a infraestrutura de teste, como fechar conexões com o banco de dados ou remover dados de teste.

**@TestInstance(Lifecycle.PER_CLASS)**

A anotação `@TestInstance(Lifecycle.PER_CLASS)` indica que uma instância de classe deve ser criada para cada teste. Isso
é útil quando você precisa compartilhar dados ou estado entre testes.

**@DataJpaTest**

A anotação `@DataJpaTest` configura um banco de dados em memória para testes. Isso é útil para testar classes que usam a
persistência de dados.

**@Components**

A anotação `@Components` indica que uma classe é um componente Spring. Isso significa que a classe pode ser gerenciada
pelo Spring Framework.

**@Controller**

A anotação `@Controller` indica que uma classe é um controlador Spring MVC. Os controladores MVC são responsáveis por
lidar com as solicitações HTTP.

**@Service**

A anotação `@Service` indica que uma classe é um serviço Spring. Os serviços são responsáveis por implementar a lógica
de negócios.

**@Entity**

A anotação `@Entity` indica que uma classe é uma entidade JPA. As entidades JPA são mapeadas para tabelas em um banco de
dados.

**@Mock**

A anotação `@Mock` indica que uma variável é um mock. Os mocks são objetos simulados que podem ser usados para testar
classes que dependem de outros objetos.

**@InjectMocks**

A anotação `@InjectMocks` indica que uma classe deve ser injetada com mocks. Isso é útil para testar classes que
dependem de outros objetos.

**@WebMvcTest**

A anotação `@WebMvcTest` configura um ambiente de teste para testes de integração do Spring MVC. Isso é útil para testar
controladores MVC com recursos como o Spring Security.

**@SpringBootTest**

A anotação `@SpringBootTest` configura um ambiente de teste para testes de integração do Spring Boot. Isso é útil para
testar classes e componentes do Spring Boot.

**Exemplo de uso**

Aqui está um exemplo de como usar as anotações de teste:

```
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MeuTeste {

    @Autowired
    private MeuComponente meuComponente;

    @Test
    public void meuTeste() {
        // ...
    }
}
```

Neste exemplo, a anotação `@SpringBootTest` configura um ambiente de teste para testes de integração do Spring Boot. A
anotação `@Autowired` é usada para injetar o componente `MeuComponente` no teste. O método `meuTeste()` é anotado
com `@Test` para indicar que é um teste.
