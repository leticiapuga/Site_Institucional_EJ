import styles from "./Login.module.css";
import logoInovale from "../../assets/logo_login_e_cadastro.png";
export default function Login() {
  return (
    <div className={styles.container}>
      <aside className={styles.brandSection}>
        <img src={logoInovale} alt="Logo Inovale Jr" className={styles.logo} />
      </aside>
      <main className={styles.formSection}>
        <h2>Login</h2>
        <form className={styles.form}>
          <label htmlFor="email">E-mail</label>
          <input
            type="email"
            id="email"
            placeholder="Digite seu e-mail"
            required
          />

          <label htmlFor="password">Senha</label>
          <input
            type="password"
            id="password"
            placeholder="Digite sua senha"
            required
          />

          <div className={styles.formOptions}>
            <label>
              <input type="checkbox" /> Lembre-me
            </label>
            <a href="#">Esqueceu a senha?</a>
          </div>

          <button className={styles.buttonLogin} type="submit">Entrar</button>
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
