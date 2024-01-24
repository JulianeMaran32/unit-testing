## Utilizando o WSL2 no Windows

1. Abrir o terminal WSL no Windows: `wsl`
2. Atualizar índice do pacote: `sudo apt update`

### Instalando o Maven no WSL

1. Instalar o Maven: `sudo apt install maven`
2. Verificar o Maven: `mvn --version`

### Instalando o MySQL Server no WSL

1. Instalar o MySQL Server: `sudo apt install mysql-server`
2. Verificar o MySQL: `mysql --version`
3. Testar o MySQL
    * Iniciar o MySQL: `sudo service mysql start`
    * Checar o status: `sudo service mysql status`
    * Parar o MySQL: `sudo service mysql stop`

## Referências

### Tutoriais

* [Install Maven on WSL](https://kontext.tech/article/630/install-maven-on-wsl)
* [Install MySQL on WSL](https://kontext.tech/article/615/install-mysql-on-wsl)
* [Install MongoDB on WSL](https://kontext.tech/article/620/install-mongodb-on-wsl)
* [Install Redis on WSL](https://kontext.tech/article/618/install-redis-on-wsl)