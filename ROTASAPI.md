

# Documentação da API

**Base URL local:** `http://localhost:8080`  
**Base URL produção:** `https://site-institucional-ej.onrender.com/`  
**Formato de Dados:** JSON (`application/json`)

## 🔐 Autenticação e Segurança

Esta API utiliza autenticação via Token.
*   **Rotas Públicas:** Acessíveis sem token.
*   **Rotas Privadas (Admin):** Requerem o cabeçalho `Authorization`.

**Exemplo de Cabeçalho para Rotas Privadas:**
```http
Authorization: Bearer <seu_token_aqui>
```

---

## 1. Controlador de Autenticação
Gerencia o registro, login e validação de contas.

### Registrar Usuário
Cria uma nova conta de usuário.
*   **Método:** `POST`
*   **Rota:** `/auth/registrar`
*   **Acesso:** 🟢 Público

**Corpo da Requisição (JSON):**
```json
{
  "nome": "string",
  "email": "string",
  "senha": "string" // Mínimo 4 caracteres
}
```

**Resposta (200 OK):**
```json
{
  "id": "uuid",
  "nome": "string",
  "email": "string"
}
```

### Entrar (Login)
Autentica o usuário e retorna o token de acesso.
*   **Método:** `POST`
*   **Rota:** `/auth/entrar`
*   **Acesso:** 🟢 Público

**Corpo da Requisição (JSON):**
```json
{
  "email": "string",
  "senha": "string"
}
```

**Resposta (200 OK):**
```json
{
  "id": "uuid",
  "nome": "string",
  "email": "string",
  "token": "string" // Use este token nas requisições privadas
}
```

### Validar Conta
Valida o cadastro através de um código enviado via e-mail no cadastro.
*   **Método:** `GET`
*   **Rota:** `/auth/validar/{codigo}`
*   **Acesso:** 🟢 Público

**Parâmetros:**
*   `codigo` (path): Código de validação recebido.

---

## 2. Controlador de Recuperação de Senha

### Gerar Código de Recuperação
Envia um código para o e-mail do usuário para redefinir a senha.
*   **Método:** `POST`
*   **Rota:** `/recuperarSenha/gerarCodigo`
*   **Acesso:** 🟢 Público

**Corpo da Requisição (JSON):**
```json
{
  "email": "string"
}
```

### Atualizar Senha
Define a nova senha utilizando o código recebido.
*   **Método:** `PATCH`
*   **Rota:** `/recuperarSenha/atualizar/{codigoRecuperacao}`
*   **Acesso:** 🟢 Público

**Parâmetros:**
*   `codigoRecuperacao` (path): O código enviado por e-mail.

**Corpo da Requisição (JSON):**
```json
{
  "codigo": "string", // O mesmo código do path (redundância comum)
  "senha": "string"   // Nova senha
}
```

---

## 3. Controlador de Parcerias
Gerencia as empresas parceiras exibidas no site.

### Listar Parcerias
*   **Método:** `GET`
*   **Rota:** `/parceria`
*   **Acesso:** 🟢 Público

**Resposta (Array):**
```json
[
  {
    "id": "uuid",
    "nomeEmpresa": "string",
    "logoUrl": "string",
    "siteUrl": "string"
  }
]
```

### Buscar Parceria por ID
*   **Método:** `GET`
*   **Rota:** `/parceria/{id}`
*   **Acesso:** 🟢 Público

### Criar Parceria
*   **Método:** `POST`
*   **Rota:** `/parceria`
*   **Acesso:** 🔴 Administrador (Token necessário)

**Corpo da Requisição:**
```json
{
  "nomeEmpresa": "string",
  "logoUrl": "string",
  "siteUrl": "string"
}
```

### Atualizar Parceria
*   **Método:** `PATCH`
*   **Rota:** `/parceria/{id}`
*   **Acesso:** 🔴 Administrador

### Deletar Parceria
*   **Método:** `DELETE`
*   **Rota:** `/parceria/{id}`
*   **Acesso:** 🔴 Administrador

---

## 4. Controlador Quem Somos (Membros)
Gerencia a equipe/membros

### Listar Membros
*   **Método:** `GET`
*   **Rota:** `/membro`
*   **Acesso:** 🟢 Público

**Resposta (Array):**
```json
[
  {
    "id": "uuid",
    "nome": "string",
    "cargo": "string",
    "fotoUrl": "string",
    "linkedinUrl": "string",
    "githubUrl": "string"
  }
]
```

### Buscar Membro por ID
*   **Método:** `GET`
*   **Rota:** `/membro/{id}`
*   **Acesso:** 🟢 Público

### Adicionar Membro
*   **Método:** `POST`
*   **Rota:** `/membro`
*   **Acesso:** 🔴 Administrador

**Corpo da Requisição:**
```json
{
  "nome": "string",
  "cargo": "string",
  "fotoUrl": "string",
  "linkedinUrl": "string",
  "githubUrl": "string"
}
```

### Atualizar Membro
*   **Método:** `PATCH`
*   **Rota:** `/membro`
*   **Acesso:** 🔴 Administrador
*   **Nota:** O ID deve ser enviado no corpo da requisição conforme a documentação fornecida.

**Corpo da Requisição:**
```json
{
  "id": "uuid",
  "nome": "string",
  "cargo": "string",
  "fotoUrl": "string",
  "linkedinUrl": "string",
  "githubUrl": "string"
}
```

### Remover Membro
*   **Método:** `DELETE`
*   **Rota:** `/membro/{id}`
*   **Acesso:** 🔴 Administrador

---

## 5. Controlador de Casos de Sucesso (Cases)
Gerencia o portfólio de projetos.

### Listar Cases
*   **Método:** `GET`
*   **Rota:** `/cases`
*   **Acesso:** 🟢 Público

**Resposta (Array):**
```json
[
  {
    "id": "uuid",
    "nomeProjeto": "string",
    "cliente": "string",
    "descricaoSolucao": "string",
    "depoimentoCliente": "string",
    "imagemUrl": "string",
    "nomeServico": "string"
  }
]
```

### Buscar Case por ID
*   **Método:** `GET`
*   **Rota:** `/cases/{id}`
*   **Acesso:** 🟢 Público

### Criar Case
*   **Método:** `POST`
*   **Rota:** `/cases`
*   **Acesso:** 🔴 Administrador

**Corpo da Requisição:**
```json
{
  "nomeProjeto": "string",
  "cliente": "string",
  "descricaoSolucao": "string",
  "depoimentoCliente": "string",
  "imagemUrl": "string",
  "idServico": "uuid" // ID do serviço relacionado
}
```

### Atualizar Case
*   **Método:** `PATCH`
*   **Rota:** `/cases/{id}`
*   **Acesso:** 🔴 Administrador

### Deletar Case
*   **Método:** `DELETE`
*   **Rota:** `/cases/{id}`
*   **Acesso:** 🔴 Administrador

---

## 6. Controlador de Contato
Gerencia as mensagens enviadas pelo formulário de "Fale Conosco".

### Enviar Mensagem (Público)
*   **Método:** `POST`
*   **Rota:** `/contato`
*   **Acesso:** 🟢 Público

**Corpo da Requisição:**
```json
{
  "nome": "string",
  "email": "string",
  "telefone": "string",
  "mensagem": "string"
}
```

### Listar Mensagens (Admin)
*   **Método:** `GET`
*   **Rota:** `/contato`
*   **Acesso:** 🔴 Administrador

**Resposta:** Retorna lista de mensagens incluindo `dataEnvio` e status `lido`.

### Atualizar Mensagem (Marcar como lida)
*   **Método:** `PATCH`
*   **Rota:** `/contato/{id}`
*   **Acesso:** 🔴 Administrador

### Deletar Mensagem
*   **Método:** `DELETE`
*   **Rota:** `/contato/{id}`
*   **Acesso:** 🔴 Administrador

---

## Exemplos de Consumo (Front-end)

### 1. Exemplo usando `fetch` (Javascript Nativo)

**Login (Obter Token):**
```javascript
const loginOptions = {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    email: "admin@empresa.com",
    senha: "1234"
  })
};

fetch('http://localhost:8080/auth/entrar', loginOptions)
  .then(response => response.json())
  .then(data => {
    console.log('Login Sucesso:', data);
    localStorage.setItem('token', data.token); // Salvar token
  })
  .catch(err => console.error(err));
```

**Criar Parceria (Rota Privada com Token):**
```javascript
const token = localStorage.getItem('token');

const options = {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': `Bearer ${token}` // Importante para rotas Admin
  },
  body: JSON.stringify({
    nomeEmpresa: "Nova Tech",
    logoUrl: "http://img.com/logo.png",
    siteUrl: "http://novatech.com"
  })
};

fetch('http://localhost:8080/parceria', options)
  .then(response => response.json())
  .then(data => console.log('Parceria criada:', data))
  .catch(err => console.error(err));
```

### 2. Exemplo usando `axios`

```javascript
import axios from "axios";

// Configurar Axios com Token (se já estiver logado)
const api = axios.create({
  baseURL: 'http://localhost:8080',
});

// Adicionar interceptor para injetar o token automaticamente
api.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// Exemplo: Listar Cases (Público)
api.get('/cases')
  .then(response => console.log('Cases:', response.data))
  .catch(error => console.error(error));

// Exemplo: Criar Membro (Privado - requer token no localStorage)
const novoMembro = {
  nome: "João Silva",
  cargo: "Dev Backend",
  fotoUrl: "url_foto",
  linkedinUrl: "url_linkedin",
  githubUrl: "url_github"
};

api.post('/membro', novoMembro)
  .then(response => console.log('Membro criado:', response.data))
  .catch(error => console.error('Erro (Provavelmente 403 Forbidden se sem token):', error));
```