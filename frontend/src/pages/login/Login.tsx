import { useState } from "react";
import styles from "./Login.module.css";
import logoInovale from "../../assets/logo_login_e_cadastro.png";

export default function Login() {
  const [form, setForm] = useState({ email: "", password: "" });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  function validatePassword(password: string) {
    const regex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%&*_\-\.])[A-Za-z\d!@#$%&*_\-\.]{8,64}$/;
    return regex.test(password);
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setLoading(true);
    setError("");

    if (!validatePassword(form.password)) {
      setError(
        "A senha deve ter entre 8 e 64 caracteres, conter ao menos uma letra maiúscula, uma minúscula, um número e um caractere especial (!@#$%&*_-.)."
      );
      setLoading(false);
      return;
    }
    try {
      const res = await fetch(" Adicionar ", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });
      if (!res.ok) throw new Error("Login inválido");
    } catch (err) {
      setError("E-mail ou senha inválidos.");
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
            required
            value={form.email}
            onChange={handleChange}
          />

          <label htmlFor="password">Senha</label>
          <input
            type="password"
            id="password"
            name="password"
            placeholder="Digite sua senha"
            required
            value={form.password}
            onChange={handleChange}
          />
          {error && (
            <div
              style={{ color: "#e95c0c", marginTop: 4, fontSize: "0.95rem" }}
            >
              {error}
            </div>
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
