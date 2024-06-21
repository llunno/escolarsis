# Escolarsis

O Escolarsis é um sistema de gerenciamento escolar que permite aos professores avaliar seus alunos com base em disciplinas. Este documento fornece instruções sobre como executar o projeto usando o DevContainer.

## Pré-requisitos
Certifique-se de ter os seguintes requisitos instalados em seu ambiente de desenvolvimento:

- Docker
- Visual Studio Code
- Extensão Remote - Containers (no Visual Studio Code)

## Configurando o DevContainer
Siga as etapas abaixo para configurar o DevContainer e executar o projeto:

1. Clone o repositório do Escolarsis em seu ambiente de desenvolvimento.
2. Abra o Visual Studio Code e navegue até a pasta raiz do projeto.
3. Quando solicitado, clique em "Reopen in Container" para abrir o projeto no DevContainer.
4. Aguarde até que o DevContainer seja configurado e as dependências sejam instaladas.
5. Após a conclusão, você estará pronto para executar o projeto.

## Executando o projeto
Para executar o Escolarsis, siga as etapas abaixo:

1. Instale as dependências do projeto Java utilizando o comando `mvn install`.
2. Execute a aplicação com o comando `mvn spring-boot:run`.
3. Abra um navegador da web e acesse `http://localhost:8080` para visualizar o sistema.

Agora você pode começar a utilizar o Escolarsis para gerenciar suas avaliações escolares!
