# Sistema Academico Simplificado

Este projeto gera relatórios para turmas e utiliza um banco de dados PostgreSQL para armazenamento de dados. A seguir, veja como configurar e rodar o projeto na sua máquina.

## Pré-requisitos

- **Java 17**: Certifique-se de ter o JDK 17 instalado.
- **Maven**: Necessário para construir e executar o projeto.
- **Docker**: Utilizado para criar a imagem do PostgreSQL.
- **Git**: Para clonar o repositório.

## Passo a Passo

### 1. Clonar o Repositório

Clone o repositório do projeto para sua máquina:

```bash
git clone https://github.com/devruchoa/sistema-academico-simplificado.git
cd sistema-academico-simplificado
```

### 2. Configurar o Banco de Dados com Docker

#### a. Verifique as Credenciais

Abra o arquivo `application.properties` e confira as seguintes propriedades (ajuste conforme necessário):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

#### b. Criar e Iniciar o Container do PostgreSQL

Utilize o comando abaixo para criar e iniciar um container Docker com o PostgreSQL, passando as credenciais definidas:

```bash
docker run --name postgres-container \
  -e POSTGRES_USER=seu_usuario \
  -e POSTGRES_PASSWORD=sua_senha \
  -e POSTGRES_DB=nome_do_banco \
  -p 5432:5432 \
  -d postgres:latest
```

**Nota:** Certifique-se de que nenhuma outra instância do PostgreSQL esteja a utilizar a porta 5432.

### 3. Rodar o Projeto

Com o container do PostgreSQL ativo e as credenciais configuradas, compile e execute o projeto:

```bash
mvn clean install
mvn spring-boot:run
```

O projeto iniciará (normalmente na porta `8080`) e estará pronto para uso.

### 4. Gerar e Acessar Relatórios

Para gerar o relatório de uma turma específica, utilize o endpoint abaixo (substitua `{turmaId}` pelo identificador da turma desejada):

```bash
http://localhost:8080/relatorios/turma/{turmaId}
```

Basta acessar esse URL pelo navegador ou via ferramenta de requisição (como o Postman) para visualizar o relatório.

---

## Considerações Finais

- **Dependências:** Garanta que o Java 17, Maven e Docker estejam corretamente instalados e configurados.
- **Banco de Dados:** Verifique sempre se o container do PostgreSQL está a rodar antes de iniciar o projeto.
- **Logs:** Em caso de erro, consulte os logs do projeto e do container Docker para diagnóstico.

Agora você já pode rodar o seu projeto, gerar os relatórios e acessá-los conforme necessário!
