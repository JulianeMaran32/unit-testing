## Pageable

Exemplo de configuração:

```yaml
spring:
  data:
    web:
      pageable:
        default-page-size: 15  # Tamanho padrão da página
        max-page-size: 50    # Tamanho máximo da página
        one-indexed-parameters: true  # Iniciar a numeração de páginas em 1
        page-parameter: page    # Parâmetro de solicitação para a página
        prefix: _            # Prefixo para parâmetros de paginação
        qualifier-delimiter: .  # Separador para parâmetros qualificados
        size-parameter: size     # Parâmetro de solicitação para o tamanho da página
        filter-parameters: q  # Parâmetro de solicitação usado para especificar um filtro de consulta        
    sort:
      sort-parameter: sort  # Parâmetro de solicitação para a ordenação
  mvc:
    # Habilita o filtro de consulta para o parâmetro de solicitação `q`
    filter:
      common:
        disable-default-filters: false

```

**Observação:**

Pode ser utilizado:

* `p` ou `page`
* `s` ou `size`

### Explicação dos parâmetros

* `default-page-size`: Define o número de elementos a serem exibidos por página, a menos que um tamanho diferente seja
  especificado na solicitação.
* `max-page-size`: Define o limite máximo para o tamanho da página, impedindo que solicitações maliciosas extraiam
  grandes conjuntos de dados.
* `one-indexed-parameters`: Especifica se os parâmetros de página e tamanho devem começar em 1 (true) ou 0 (false).
* `page-paramete`r: Define o nome do parâmetro de solicitação usado para indicar o número da página.
* `prefix`: Define um prefixo para todos os parâmetros de paginação.
* `qualifier-delimiter`: Define o caractere usado para separar qualificadores de parâmetros.
* `size-parameter`: Define o nome do parâmetro de solicitação usado para indicar o tamanho da página.
* `sort-parameter`: Define o nome do parâmetro de solicitação usado para especificar a ordenação.

### Configurando URL

* http://localhost:8080/api/produtos?page=2&size=10&sort=nome,asc
    * Busca a segunda página de produtos, com 10 elementos por página, ordenados por nome em ordem crescente.

### Exemplos de chamadas utilizando paginação

* Para buscar a primeira página de produtos, com 10 elementos por página, ordenados por nome em ordem
  crescente: http://localhost:8080/api/produtos
* Para buscar a segunda página de produtos, com 20 elementos por página, ordenados por nome em ordem
  decrescente: http://localhost:8080/api/produtos?page=2&size=20&sort=nome,desc
* Para buscar a primeira página de produtos, com o tamanho da página padrão (15 elementos), ordenados por preço em ordem
  crescente: http://localhost:8080/api/produtos?sort=preco,asc
* Para buscar a primeira página de produtos, com o tamanho da página padrão, ordenados por nome e preço, primeiro por
  nome em ordem crescente e depois por preço em ordem
  decrescente: http://localhost:8080/api/produtos?sort=nome,asc.preco,desc
* Buscar todos os produtos, sem paginação: http://localhost:8080/api/produtos?size=-1
* Buscar os produtos com o nome "celular", com 10 elementos por página, ordenados por data de criação em ordem
  decrescente: http://localhost:8080/api/produtos?q=celular&size=10&sort=dataCriacao,desc
* Buscar os produtos com o nome "Carro" na primeira página, com 5 elementos por página, ordenados por ID em ordem
  crescente: http://localhost:8080/api/produtos?nome=Carro&s=5&sort=id,asc
* Buscar todos os produtos, com 10 elementos por página, ordenados por nome e preço em ordem crescente, primeiro por
  nome e depois por preço: http://localhost:8080/api/produtos?size=10&sort=nome.asc,preco.asc
* Buscar os produtos com o preço entre R$100,00 e R$200,00, com 20 elementos por página, ordenados por quantidade em
  ordem crescente: http://localhost:8080/api/produtos?precoFrom=100&precoTo=200&size=20&sort=quantidade,asc





