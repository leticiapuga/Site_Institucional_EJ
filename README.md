# Site_Institucional_EJ
Este repositório contém a solução de um desafio trainee da Include Jr., empresa júnior de tecnologia da UFC - Campus de Russas. O objetivo foi desenvolver o site institucional da Inovale, empresa júnior de Engenharia Mecânica.

---
- Link da elicitação de requisitos (https://docs.google.com/document/d/1IL8RIdbZuERfuiO6Ecc2O6XUYXK-Abi2/edit)

## Funcionalidades

- Página institucional completa com informações da empresa
- Página de serviços, membros, contato e parcerias
- Área administrativa com login e cadastro
- Cadastro de usuários
- Listagem, criação, edição e remoção de parcerias (Admin)
- Consumo de API hospedada no Render
- Componentes reutilizáveis (Navbar, Footer, Cards etc.)

---

## Tecnologias Utilizadas

- React.js – estrutura principal do projeto (Frontend) 
- React Router DOM – controle de rotas e navegação entre páginas  
- CSS Modules – estilização isolada e moderna  
- React Icons – ícones de plataforma e avaliações  
- Vite – ferramenta de build e ambiente de desenvolvimento
- Java/spring boot (Backend)
- A API deste projeto conta com uma documentação completa gerada automaticamente pelo Swagger UI, permitindo visualizar todos os endpoints, seus modelos de dados e realizar testes diretamente pelo navegador.

- 🔗 Acesso Online

- A documentação pode ser acessada no ambiente de produção através do link: (https://site-institucional-ej.onrender.com/swagger-ui/index.html#/)

- 💻 Acesso Local

- Ao executar o backend na sua máquina, utilize o endereço:( http://localhost:8080/swagger-ui/index.html#/)

---

## Tecnologias Necessárias

Antes de rodar o projeto, certifique-se de ter instalado:  

- Node.js (versão 16 ou superior)  
- npm (gerenciador de pacotes)  
- Navegador moderno (Chrome, Firefox, Edge, etc.)  

---

## Funcionalidades Principais

### Área Institucional

- Exibição de informações sobre a Inovale Jr.
- Página de serviços oferecidos
- Página de membros e estrutura organizacional
- Página de contato 

### Gerenciamento de Parcerias, membros, casos de sucesso e parcerias (Page do Administrador)

- Opçoes de listar, editar, adicionar e remover.
    

### Autenticação

- Cadastro de novos usuários
- Login para acesso à área administrativa
- Validação e armazenamento de token


### Componentes Reutilizáveis

- Navbar com links e barra de busca  
- Footer padronizado  
- Cards clicáveis que redirecionam para detalhes específicos  


## Como Rodar o Projeto Localmente

1. Crie uma pasta e abra o terminal nela  
2. Clone o repositório:  (git clone https://github.com/leticiapuga/Site_Institucional_EJ.git)
3. Abrir Pasta com os arquivos:
   (cd frontend)
   
4. Instalar as dependencias para rodar o projeto:
   (npm install)
   
5. Para rodar o Projeto:
   (npm run dev)
   
6. Depois copie o link que vai aparecer no terminal cole no navegador de sua escolha.


---

## Melhorias Futuras

- Otimizar o carregamento de dados e performance
- Aprimorar responsividade em telas menores
- adicionar integração do banco de dados com as outras sessões do admin, que por conta do tempo só houve tempo para integrar o login e cadastro.
- reajustar e organizar melhor algumas estilizações do front.
