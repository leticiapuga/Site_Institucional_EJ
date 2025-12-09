// Deixamos vazio para que ele use a URL relativa (mesmo domínio do site)
const API_BASE = "";

async function apiRequest(
  endpoint: string,
  method: string = "GET",
  body: any = null,
  auth: boolean = false
) {
  const headers: any = {
    "Content-Type": "application/json",
  };

  if (auth) {
    const token = localStorage.getItem("token");
    if (!token) {
      // Opcional: Redirecionar para login se não houver token
      console.warn("Token não encontrado para requisição autenticada"); 
      // throw new Error("Token não encontrado"); // Descomente se quiser forçar o erro
    } else {
      headers["Authorization"] = `Bearer ${token}`;
    }
  }

  const config: RequestInit = {
    method,
    headers,
  };

  if (body) {
    config.body = JSON.stringify(body);
  }

  // O fetch vai montar a URL assim: "https://seu-site.com" + "" + "/auth/entrar"
  const response = await fetch(`${API_BASE}${endpoint}`, config);
  
  // Tratamento para quando a resposta não é JSON (ex: erro 500 do servidor ou 404 HTML)
  const contentType = response.headers.get("content-type");
  let data;
  if (contentType && contentType.indexOf("application/json") !== -1) {
    data = await response.json();
  } else {
    data = { message: await response.text() };
  }

  if (!response.ok) {
    throw new Error(data?.message || "Erro ao acessar a API");
  }

  return data;
}

const API = {
  login: (email: string, senha: string) =>
    apiRequest("/auth/entrar", "POST", { email, senha }),

  registrar: (nome: string, email: string, senha: string) =>
    apiRequest("/auth/registrar", "POST", { nome, email, senha }),

  listarParcerias: () => apiRequest("/parcerias", "GET", null, true),
};

export default API;