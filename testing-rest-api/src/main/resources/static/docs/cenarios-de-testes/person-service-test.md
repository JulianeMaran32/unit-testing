## Testando Camada do Repository

### Objetivo Geral

Testar as operações CRUD (Create, Read, Update, Delete) de um serviço `PersonService` que interage com um
repositório `PersonRepository`, garantindo seu correto funcionamento e comportamento adequado em diferentes cenários.

### Inicializar o ambiente de teste

* Criar um contexto de teste usando Mockito para simular o comportamento do repositório.
* Injetar o repositório mockado (`@Mock`) no serviço a ser testado (`@InjectMocks`).
* Preparar dados de teste, incluindo uma lista de pessoas e objetos `Person`.

### 1. Testa busca de todas as pessoas cadastradas

* **Objetivo:** Verificar se o serviço `PersonService` retorna corretamente todas as pessoas existentes no repositório.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma lista específica de pessoas.
    * O teste chama o método `findAll()` do serviço.
    * O teste compara a lista retornada pelo serviço com a lista esperada.

### 2. Testa busca de pessoas com repositório vazio

* **Objetivo:** Verificar se o serviço retorna uma lista vazia quando não há pessoas registradas no repositório.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma lista vazia.
    * O teste chama o método `findAll()` do serviço.
    * O teste verifica se a lista retornada pelo serviço está vazia.

### 3. Testa busca de pessoas por ID existente

* **Objetivo:** Verificar se o serviço retorna a pessoa correta quando o ID fornecido existe no repositório.

* **Etapas:**
    * O teste define um ID existente e a pessoa esperada.
    * O teste configura o repositório mockado para retornar a pessoa esperada quando buscado pelo ID.
    * O teste chama o método `findById()` do serviço com o ID existente.
    * O teste compara a pessoa retornada pelo serviço com a pessoa esperada.

### 4. Testa busca por todas as pessoas

* **Objetivo:** Verificar se o serviço lança a exceção `PersonNotFoundException` quando o ID fornecido não existe no
  repositório.

* **Etapas:**
    * O teste define um ID inexistente.
    * O teste configura o repositório mockado para retornar uma lista vazia (simulando a não existência da pessoa).
    * O teste chama o método `findById()` do serviço com o ID inexistente.
    * O teste espera que a exceção `PersonNotFoundException` seja lançada.

### 5. Testa criação de pessoa com sucesso

* **Objetivo:** Verificar se o serviço cria uma nova pessoa no repositório e retorna a pessoa criada.

* **Etapas:**
    * O teste configura o repositório mockado para não encontrar pessoa com o mesmo email (simulando a criação de uma
      nova pessoa).
    * O teste chama o método `create()` do serviço com uma nova pessoa.
    * O teste verifica se a pessoa retornada pelo serviço é a mesma que foi criada.

### 6. Testa criação de pessoa com email existente

* **Objetivo:** Verificar se o serviço lança a exceção `PersonNotFoundException` quando tenta-se criar uma pessoa com um
  email já existente no repositório.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma pessoa com o mesmo email (simulando a existência de uma
      pessoa com o email).
    * O teste chama o método `create()` do serviço com uma pessoa com email já existente.
    * O teste espera que a exceção `PersonNotFoundException` seja lançada.

### 7. Testa a busca de todas as pessoas com lista específica

* **Objetivo:** Verificar se o serviço retorna corretamente uma lista de pessoas específica quando configurada no
  repositório mockado.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma lista específica de pessoas (duas pessoas no caso).
    * O teste chama o método `findAll()` do serviço.
    * O teste verifica se a lista retornada pelo serviço é a mesma lista configurada no repositório.

### 8. Testa a busca de todas as pessoas e retorna uma lista vazia

* **Objetivo:** Verificar se o serviço retorna uma lista vazia quando o repositório mockado está configurado para
  retornar uma lista vazia.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma lista vazia.
    * O teste chama o método `findAll()` do serviço.
    * O teste verifica se a lista retornada pelo serviço está vazia.

### 9. Testa a busca de pessoas por ID existente

* **Objetivo:** Verificar se o serviço retorna a pessoa correta quando o ID fornecido existe no repositório mockado.

* **Etapas:**
    * O teste define um ID existente e configura o repositório mockado para retornar uma pessoa específica para esse ID.
    * O teste chama o método `findById()` do serviço com o ID existente.
    * O teste compara a pessoa retornada pelo serviço com a pessoa configurada no repositório.

### 10. Testa a busca de todas as pessoas e retorna uma lista vazia

* **Objetivo:** Verificar se o serviço atualiza uma pessoa no repositório e retorna a pessoa atualizada.

* **Etapas:**
    * O teste configura o repositório mockado para retornar uma pessoa existente quando buscada por ID.
    * O teste modifica alguns atributos da pessoa e chama o método `update()` do serviço com a pessoa modificada.
    * O teste verifica se a pessoa retornada pelo serviço possui os atributos atualizados.

### 11. Testa a remoção de pessoas

* **Objetivo:** Verificar se o serviço chama o método de remoção no repositório com o ID correto da pessoa a ser
  removida.

* **Etapas:**
    * O teste define um ID e configura o repositório mockado para retornar uma pessoa existente para esse ID.
    * O teste configura o repositório mockado para não fazer nada quando o método `delete()` for chamado (simulando a
      remoção).
    * O teste chama o método `delete()` do serviço com o ID da pessoa.
    * O teste verifica se o método `delete()` do repositório foi chamado uma vez com o ID correto.

