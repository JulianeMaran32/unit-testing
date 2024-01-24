### Comandos Docker

* Inicializar o Docker utilizando o WSL2

```shell
sudo service docker start
```

---

### Comandos Maven

* Instalar as dependências sem rodar os testes

```shell
mvn clean package -DskipTests
```

* Rodar os testes

```shell
mvn test
```

* Rodar a aplicação sem os testes

```shell
mvn spring-boot:run -DskipTests
```

* Rodar testes utilizando o Sonar

```shell
mvn sonar:sonar "-Dsonar.host.url=http://sonar.br" "-Dsonar.login=seuUser" "-Dsonar.password=suaSenha"
```

---

### Comandos Git

* Verificar email

```shell
git config user.email  
```

* Alterar o email

```shell
git config user.email juliane.maran@compasso.com.br
```
