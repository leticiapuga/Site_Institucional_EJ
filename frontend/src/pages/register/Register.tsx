import styles from "./Register.module.css";
import logoInovale from "../../assets/logo_login_e_cadastro.png";

export default function Register() {
  return (
    <div className={styles.container}>
      <aside className={styles.brandSection}>
        <img src={logoInovale} alt="Logo Inovale Jr" className={styles.logo} />
      </aside>
      <main className={styles.formSection}>
        <h2>Cadastro</h2>
        <form className={styles.form}>
          <label htmlFor="name">Nome</label>
          <input
            type="text"
            id="name"
            placeholder="Digite seu nome completo"
            required
          />

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
          </div>

          <button className={styles.buttonLogin} type="submit">Entrar</button>
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
