## Cenários

Cenários de teste adicionais que podemos considerar:

* Listar todas as pessoas com todos os campos
* Listar pessoas por id
* Listar pessoas por firstName
* Listar pessoas por lastName
* Listar pessoas por email
* Listar pessoas por address
* Listar pessoas por gender
* Listar pessoas com campos nulos ou vazios
* Listar pessoas com campos inválidos
* Listar pessoas com campos duplicados
* Listar pessoas com campos ordenados
* Listar pessoas com campos paginados
* Listar pessoas com um intervalo de IDs
* Listar pessoas com um intervalo de datas
* Listar pessoas com um intervalo de valores
* Listar pessoas com uma ordenação específica

## Considerações

Certifique-se de considerar os seguintes fatores:

* **Cobertura:** seus testes devem cobrir todos os possíveis casos de uso do método listar pessoas.
* **Precisão:** seus testes devem ser precisos e confiáveis.
* **Eficiência:** os seus testes devem ser eficientes e não devem consumir muito tempo ou recursos.

## Cenários de Erros

URL: http://localhost:8080/api/person

* General Erros - EN

| Code | Status                | Message                                     | Example                                          |
|:-----|:----------------------|:--------------------------------------------|:-------------------------------------------------|
| 404  | Not Found             | The requested resource doesn't exist.       | Invalid endpoint or resource has been deleted.   |
| 500  | Internal Server Error | An unexpected error occurred on the server. | Database connection failure, programming errors. |

### Listar pessoas:

URL: http://localhost:8080/api/person

* Specific Error Scenarios for Different URLs - EN

| Code | Status       | Message                                  | Example                                  |
|:-----|:-------------|:-----------------------------------------|:-----------------------------------------|
| 400  | Bad Request  | Invalid filter or pagination parameters. | Invalid `page` or `size` values.         |
| 401  | Unauthorized | Required authentication is missing.      | Missing or invalid authentication token. |

### Filtar por firstName, lastName, email:

* URLs:
    * http://localhost:8080/api/person?firstName=John
    * http://localhost:8080/api/person?lastName=Doe
    * http://localhost:8080/api/person?email=john.doe@example.com

* Specific Error Scenarios for Different URLs - EN

| Code | Status      | Message                                         | Example                                                      |
|:-----|:------------|:------------------------------------------------|:-------------------------------------------------------------|
| 400  | Bad Request | Invalid filter value.                           | Incorrect data type for `firstName`, `lastName`, or `email`. |
| 404  | Not Found   | No persons match the specified filter criteria. | No person with the given first name exists.                  |

### Listar pessoas por gender:

URL: http://localhost:8080/api/person?gender=male&gender=female

* Specific Error Scenarios for Different URLs - EN

| Code | Status      | Message               | Example                                                                 |
|:-----|:------------|:----------------------|:------------------------------------------------------------------------|
| 400  | Bad Request | Invalid gender value. | Gender value not in the allowed list (e.g., "male", "female", "other"). |

### Combinando filtros:

URL: http://localhost:8080/api/person?firstName=John&lastName=Doe&gender=male

* Specific Error Scenarios for Different URLs - EN

| Code | Status      | Message                      | Example                                        |
|:-----|:------------|:-----------------------------|:-----------------------------------------------|
| 400  | Bad Request | Conflicting filter criteria. | Filtering by both "male" and "female" genders. |

### Adiciona paginação:

URL: http://localhost:8080/api/person?page=2&size=10

* Specific Error Scenarios for Different URLs - EN

| Code | Status                | Message                                       | Example                                                         |
|:-----|:----------------------|:----------------------------------------------|:----------------------------------------------------------------|
| 400  | Bad Request           | Invalid `page` or `size` values.              | page value less than 0 or `size` value exceeding allowed limit. |
| 416  | Range Not Satisfiable | Requested page is beyond the available range. | Attempting to access a page beyond the total number of pages.   |

### Combinando filtros e paginação:

URL: http://localhost:8080/api/person?firstName=John&page=3&size=5

* Specific Error Scenarios for Different URLs - EN

| Code | Status      | Message                                  | Example                                          |
|:-----|:------------|:-----------------------------------------|:-------------------------------------------------|
| 400  | Bad Request | Invalid filter or pagination parameters. | Conflict between filter criteria and pagination. |

### Paginação, tamanho, ordenação:

URL: http://localhost:8080/api/person?page=0&size=10&sort=firstName,asc&sort=lastName,desc

* Specific Error Scenarios for Different URLs - EN

| Code | Status      | Message                   | Example                                        |
|:-----|:------------|:--------------------------|:-----------------------------------------------|
| 400  | Bad Request | Invalid sorting criteria. | Conflicting sorting orders for the same field. |


