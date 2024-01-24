## Testando Camada do Repository

### Objetivo

Testar as operações básicas de um repositório JPA para a entidade `Person`, garantindo seu correto funcionamento e a
persistência de dados no banco de dados.

### Etapas

1. Inicializar o ambiente de teste
    * Criar um contexto Spring Boot de teste focado em testes JPA, utilizando a anotação `@DataJpaTest`.
    * Injetar o repositório `PersonRepository` a ser testado.
    * Criar objetos `Person` de teste para serem utilizados nos cenários.
2. Executar os testes
    * **Salvar pessoas:** Salvar um objeto `Person` e assertar se o objeto salvo possui um ID maior que zero, indicando
      persistência no banco.
    * **Buscar por todas as pessoas:** Salvar duas pessoas e assertar se a lista retornada pelo método `findAll()`
      contém as duas pessoas salvas.
    * **Buscar por ID:** Salvar uma pessoa e assertar se a busca pelo ID retorna a pessoa correta.
    * **Buscar por email:** Salvar uma pessoa e assertar se a busca pelo email retorna a pessoa correta.
    * **Atualizar pessoa:** Salvar uma pessoa, atualizar seus atributos, salvar novamente e assertar se os novos valores
      foram persistidos.
    * **Remover pessoa:** Salvar uma pessoa, remover pelo ID e assertar se a busca pelo ID não retorna mais a pessoa.
    * **Buscar por JPQL:** Salvar uma pessoa e assertar se a busca por JPQL utilizando `firstName` e `lastName` retorna
      a pessoa correta.
    * **Buscar por JPQL com parâmetros nomeados:** Salvar uma pessoa e assertar se a busca por JPQL utilizando
      parâmetros nomeados retorna a pessoa correta.
    * **Buscar por SQL nativo:** Salvar uma pessoa e assertar se a busca por SQL nativo retorna a pessoa correta.
    * **Buscar por SQL nativo com parâmetros nomeados:** Salvar uma pessoa e assertar se a busca por SQL nativo
      utilizando parâmetros nomeados retorna a pessoa correta.

