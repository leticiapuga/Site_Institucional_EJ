const API_BASE = "https://site-institucional-ej.onrender.com";

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
    if (!token) throw new Error("Token não encontrado");
    headers["Authorization"] = `Bearer ${token}`;
  }

  const config: RequestInit = {
    method,
    headers,
  };

  if (body) config.body = JSON.stringify(body);

  const response = await fetch(`${API_BASE}${endpoint}`, config);
  const data = await response.json();

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
