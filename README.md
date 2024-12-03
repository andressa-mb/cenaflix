# Cenaflix

O Cenaflix é um sistema de cadastro e gerenciamento de filmes desenvolvido em Java, utilizando uma arquitetura em camadas. O projeto foi projetado para demonstrar boas práticas de organização de código, separação de responsabilidades e integração com banco de dados SQL.

## Funcionalidades Principais

* **Cadastro de filmes:** Adiciona novos filmes ao sistema com informações detalhadas.
* **Edição de filmes:** Permite atualizar os dados de filmes já cadastrados.
* **Exclusão de filmes:** Remove filmes do banco de dados.
* **Pesquisa de filmes:** Localiza filmes cadastrados a partir de critérios específicos.
* **Listagem de filmes:** Exibe uma lista completa de filmes armazenados.
* **Limpeza de dados:** Reseta os campos do formulário para facilitar novos cadastros.

## Arquitetura do Sistema

O projeto segue uma arquitetura em camadas, garantindo a separação clara de responsabilidades, melhor manutenção e escalabilidade do código.

### 1. Camada de Modelos (Beans)
* Pacote: beans
- Contém as classes que representam as entidades do sistema, como:
  - Filme.java: Representa os atributos de um filme, como título, data de lançamento e categoria.
- Estas classes incluem:
  - Atributos com tipos específicos.
  - Métodos getters e setters para encapsulamento.
  - Construtores para inicialização.

### 2. Camada de Persistência (DAO - Data Access Object)
* Pacote: dao
- Responsável por gerenciar a interação com o banco de dados SQL.
- Implementa operações como:
  - cadastrar(): Adiciona um novo filme ao banco de dados.
  - editar(): Atualiza informações de um filme existente.
  - excluir(): Exclui um filme do banco de dados.
  - buscar(): Recupera um ou mais filmes com base em critérios específicos.
  - listarTodos(): Retorna a lista completa de filmes.

### 3. Camada de Conexão
* Pacote: conexao
- Inclui a classe Conexao.java, que gerencia a conexão com o banco de dados SQL.
- Configurações gerais:
  - Banco de dados: MySQL ou outro banco relacional compatível.
  - Driver JDBC: Gerencia a comunicação entre a aplicação Java e o banco de dados.
  - Método getConnection(): Retorna uma conexão ativa com o banco de dados.

### 4. Camada de Apresentação (Forms)
* Pacote: forms
- Contém as interfaces gráficas do sistema, desenvolvidas em Java Swing.
- Principais telas:
  - Tela de Cadastro: Formulário para adicionar, editar, excluir ou buscar filmes por id.
  - Tela de Listagem: Exibe os filmes em uma tabela interativa e permite buscar filmes por título.

## Tecnologias Utilizadas
* Linguagem de programação: Java
* Interface gráfica: Java Swing
* Banco de dados: MySQL (ou outro banco relacional)
* Driver JDBC: Para integração com o banco de dados
* Padrão de projeto: DAO (Data Access Object)
* Arquitetura: Em camadas (Beans, DAO, Conexão, Forms)

## Como Configurar o Projeto
### 1. Pré-requisitos
* Java JDK 11 ou superior.
* Banco de dados MySQL configurado.
* IDE Java (IntelliJ IDEA, Eclipse, NetBeans, etc.).

### 2. Configuração do Banco de Dados
* Crie um banco de dados para o projeto com o seguinte comando:
```
CREATE DATABASE cenaflix;

// Crie a tabela de filmes:

    CREATE TABLE filmes (
        id INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(100) NOT NULL,
        genero VARCHAR(50),
        diretor VARCHAR(100),
        ano INT,
        descricao TEXT
    );
```

* Atualize o arquivo de conexão (Conexao.java) com as credenciais do seu banco de dados.

### 3. Configuração do Projeto
* Clone o repositório:
```
    git clone https://github.com/andressa-mb/cenaflix.git
```

* Importe o projeto na IDE.
* Adicione o driver JDBC na Class Conexão.

### 4. Execução
* Compile e execute a classe principal (CenaflixCadastro.java) para iniciar o sistema.
