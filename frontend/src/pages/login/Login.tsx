import { useState } from "react";
import styles from "./Login.module.css";
import logoInovale from "../../assets/logo_login_e_cadastro.png";
import API from "../../services/api";

export default function Login() {
  const [form, setForm] = useState({ email: "", senha: "" });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setError("");
    setLoading(true);

    try {
      const data = await API.login(form.email, form.senha);

      if (!data.token) {
        throw new Error("Token não recebido");
      }

      localStorage.setItem("token", data.token);

      window.location.href = "/admin/services";
    } catch (err) {
      setError("E-mail ou senha incorretos.");
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className={styles.container}>
      <aside className={styles.brandSection}>
        <img src={logoInovale} alt="Logo Inovale Jr" className={styles.logo} />
      </aside>

      <main className={styles.formSection}>
        <h2>Login</h2>

        <form className={styles.form} onSubmit={handleSubmit}>
          <label htmlFor="email">E-mail</label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Digite seu e-mail"
            value={form.email}
            onChange={handleChange}
            required
          />

          <label htmlFor="senha">Senha</label>
          <input
            type="password"
            id="senha"
            name="senha"
            placeholder="Digite sua senha"
            value={form.senha}
            onChange={handleChange}
            required
          />

          {error && (
            <p style={{ color: "#e95c0c", marginTop: 6, fontSize: "0.95rem" }}>
              {error}
            </p>
          )}

          <div className={styles.formOptions}>
            <label>
              <input type="checkbox" /> Lembre-me
            </label>
            <a href="#">Esqueceu a senha?</a>
          </div>

          <button
            className={styles.buttonLogin}
            type="submit"
            disabled={loading}
          >
            {loading ? "Entrando..." : "Entrar"}
          </button>
        </form>

        <div className={styles.links}>
          <span>
            Não tem conta? <a href="/register">Cadastre-se</a>
          </span>
        </div>
      </main>
    </div>
  );
}
