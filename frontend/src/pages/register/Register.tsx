import { useState } from "react";
import styles from "./Register.module.css";
import logoInovale from "../../assets/logo_login_e_cadastro.png";

export default function Register() {
  const [form, setForm] = useState({ name: "", email: "", password: "" });
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);
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
    setSuccess(false);

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
      if (!res.ok) throw new Error("Erro ao cadastrar");
      setSuccess(true);
      setForm({ name: "", email: "", password: "" });
    } catch (err) {
      setError("Erro ao cadastrar. Tente novamente.");
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
        <h2>Cadastro</h2>
        <form className={styles.form} onSubmit={handleSubmit}>
          <label htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            name="name"
            placeholder="Digite seu nome completo"
            required
            value={form.name}
            onChange={handleChange}
          />

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
          </div>

          <button
            className={styles.buttonLogin}
            type="submit"
            disabled={loading}
          >
            {loading ? "Cadastrando..." : "Entrar"}
          </button>
          {success && (
            <div style={{ color: "#0c3845", marginTop: 8 }}>
              Cadastro realizado com sucesso!
            </div>
          )}
        </form>
        <div className={styles.links}>
          <span>
            Já possui cadastro? <a href="/login">Realizar login</a>
          </span>
        </div>
      </main>
    </div>
  );
}
