## Cenário de teste

* **Objetivo:** verifica se a página da interface Swagger UI da aplicação está acessível e sendo exibida corretamente.

* **Etapas:**

1. Inicializar o ambiente de teste
    * Criar um contexto Spring Boot simulando um ambiente web com uma porta
      definida (`webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT`).
    * Utilizar a extensão SpringExtension para habilitar recursos de testes Spring.
2. Realizar a requisição HTTP
    * Enviar uma requisição GET à URL `/api/swagger-ui/index.html` na porta configurada para o servidor de testes.
3. Validar a resposta
    * Confirmar que o código de status da resposta é 200 (sucesso).
    * Extrair o conteúdo da resposta (body) como uma string.
4. Verificar o conteúdo
    * Assegurar que a string de conteúdo da resposta contém o texto "Swagger UI", indicando a presença da interface
      Swagger UI na página.

* **Resultado dos logs:**

```shell
2024-01-23T13:25:37.437-03:00  INFO 2256 --- [testing-rest-api] [nio-8888-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2024-01-23T13:25:37.444-03:00 DEBUG 2256 --- [testing-rest-api] [nio-8888-exec-1] o.s.web.servlet.DispatcherServlet        : GET "/api/swagger-ui/index.html", parameters={}
2024-01-23T13:25:37.451-03:00 DEBUG 2256 --- [testing-rest-api] [nio-8888-exec-1] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped to ResourceHttpRequestHandler [classpath [META-INF/resources/webjars/]]
2024-01-23T13:25:37.457-03:00 DEBUG 2256 --- [testing-rest-api] [nio-8888-exec-1] o.j.s.OpenEntityManagerInViewInterceptor : Opening JPA EntityManager in OpenEntityManagerInViewInterceptor
2024-01-23T13:25:37.478-03:00 DEBUG 2256 --- [testing-rest-api] [nio-8888-exec-1] o.j.s.OpenEntityManagerInViewInterceptor : Closing JPA EntityManager in OpenEntityManagerInViewInterceptor
2024-01-23T13:25:37.479-03:00 DEBUG 2256 --- [testing-rest-api] [nio-8888-exec-1] o.s.web.servlet.DispatcherServlet        : Completed 200 OK
2024-01-23T13:25:37.547-03:00 DEBUG 2256 --- [testing-rest-api] [           main] c.j.s.t.i.s.SwaggerIntegrationTest       : CONTENT: <!-- HTML for static distribution bundle build -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Swagger UI</title>
    <link rel="stylesheet" type="text/css" href="./swagger-ui.css" />
    <link rel="stylesheet" type="text/css" href="index.css" />
    <link rel="icon" type="image/png" href="./favicon-32x32.png" sizes="32x32" />
    <link rel="icon" type="image/png" href="./favicon-16x16.png" sizes="16x16" />
  </head>

  <body>
    <div id="swagger-ui"></div>
    <script src="./swagger-ui-bundle.js" charset="UTF-8"> </script>
    <script src="./swagger-ui-standalone-preset.js" charset="UTF-8"> </script>
    <script src="./swagger-initializer.js" charset="UTF-8"> </script>
  </body>
</html>
```