```shell
wsl
sudo service docker start
docker build -t testing-rest-api .
docker compose up -d
```

Acessar a aplicação: http://localhost:8888/api/person

## Dockerfile

O Dockerfile é um arquivo de texto que descreve como criar uma imagem Docker. Ele é usado para especificar as etapas
necessárias para construir uma imagem, como quais pacotes instalar, quais arquivos copiar e quais comandos executar.

O Dockerfile é escrito em um formato de script simples que usa instruções para especificar as etapas de construção. As
instruções mais comuns são:

* FROM: Especifica a imagem base a partir da qual a imagem será construída.
* RUN: Executa um comando na imagem durante a construção.
* COPY: Copia um arquivo ou diretório para a imagem durante a construção.
* EXPOSE: Expõe uma porta na imagem para que ela possa ser acessada de fora do contêiner.
* ENTRYPOINT: Define o comando que será executado quando o contêiner for iniciado.

## Docker Compose

O Docker-compose é uma ferramenta que permite gerenciar um conjunto de contêineres Docker. Ele é usado para definir e
criar serviços Docker, que são grupos de contêineres que trabalham juntos.

O Docker-compose é escrito em um arquivo YAML que especifica os serviços a serem criados. O arquivo YAML contém
informações como o nome do serviço, a imagem Docker a ser usada, as portas a serem expostas e as variáveis de ambiente a
serem definidas.

O Docker-compose é uma ferramenta poderosa que pode ser usada para simplificar o gerenciamento de contêineres Docker.
Ele permite que você defina e crie serviços Docker com facilidade, e pode ser usado para automatizar tarefas como a
construção e a inicialização de contêineres.

## Para que servem

O Dockerfile e o Docker-compose são ferramentas complementares que podem ser usadas para criar e gerenciar contêineres
Docker. O Dockerfile é usado para criar imagens Docker, que são o núcleo de um contêiner Docker. O Docker-compose é
usado para criar serviços Docker, que são grupos de contêineres que trabalham juntos.

---

## Alguns comandos

### Linux

* Inicializa o docker: `sudo service docker start`
* Encerra o docker: `sudo service docker stop`
* Encerra e inicializa o docker: `sudo service docker restart`

### Docker

* Run `docker run`
* Executar: `docker exec`
* Listar contêineres em execução: `docker ps`
* O comanod `docker ps` retorna uma tabela com as informações: CONTAINER ID, IMAGE, COMMAND, CREATED, STATUS, PORTS,
  NAMES
* Opção para listar todos os contêineres, mesmo os parados. Sem isso, o padrão é listar apenas os contêineres em
  execução: `docker ps -a`
* Opção silenciosa para fornecer apenas os IDs numéricos dos contêineres, em vez de uma tabela inteira de informações
  sobre os contêineres: `docker ps -q`
* Build das imagens do Dockerfile: `docker build`
* Listar imagens: `docker images`
* Remove contêineres por nome ou por ID: `docker rm`
* Excluir todos os contêineres parados: `docker rm $(docker ps -a -q)`
* Parar os contêineres em execução: `docker stop`
* Parar todos os contêineres em execução: `docker stop $(docker ps -a -q)`
* Para remover todas as imagens ao mesmo tempo: `docker rmi $(docker images -q)`

### Docker Compose

* Verifica a versão do docker compose: `docker compose version`
* O comando `docker compose ls` retorna uma tabela com as informações: NAME, STATUS, CONFIG FILES
* O comando `docker compose images` retorna uma tabela com as informações: CONTAINER, REPOSITORY, TAG, IMAGE ID, SIZE
* Cria e inicia os contêineres: `docker compose up -d`
* Realiza apenas a etapa de build das imagens que serão utilizadas: `docker compose build`
* Visualiza os logs dos contêineres: `docker compose logs`
* Reinicia os contêineres: `docker compose restart`
* Lista os contêineres: `docker compose ps`
* Permite aumentar o número de réplicas de um contêinere: `docker compose scale`
* Inicia os contêineres: `docker compose start`
* Paralisa os contêineres: `docker compose stop`
* Paralisa e remove todos os contêineres e seus componentes como rede, imagem e volume: `docker compose down`

---

**Observações:**

* Listar todas as imagens, retorna uma tabela (CONTAINER | REPOSITORY | TAG | IMAGE ID | SIZE): `docker compose images`
* Você pode parar e excluir diversos contêineres passando para os comandos uma lista dos contêineres que deseja remover.
  A sintaxe do shell `$()` retorna os resultados do que tiver sido executado dentro dos parênteses. Desse modo, você
  pode criar sua lista de contêineres dentro dela para passar a informação para os comandos `stop` e `rm`.
* `-q`: é a opção usada para retornar os IDs exclusivos.
* `$()`: retorna os resultados dos IDs de imagens e docker rmi remove todas elas.

---

## Referência

* [Spring Boot MySQL Docker Compose Example](https://www.javaguides.net/2022/12/spring-boot-mysql-docker-compose-example.html)
* [Docker Compose: Spring Boot and MySQL example](https://www.bezkoder.com/docker-compose-spring-boot-mysql/)