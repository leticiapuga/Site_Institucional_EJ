import { Link } from "react-router-dom";
import styles from "./Navbar.module.css";
import logo from "../../assets/logo_inovale.svg";

export default function Navbar() {
  return (
    <nav className={styles.navbar}>
      <div className={styles.logo}>
        <img src={logo} alt="Logo" />
      </div>
      <ul className={styles.navList}>
        <li className={styles.navItem}>
          <Link to="/">Início</Link>
        </li>
        <li className={styles.navItem}>
          <Link to="/servicos">Serviços</Link>
        </li>
        <li className={styles.navItem}>
          <Link to="/nossosMembros">Nossos membros</Link>
        </li>
        <li className={styles.navItem}>
          <Link to="/contactus">Fale conosco</Link>
        </li>
        <li className={styles.navItem}>
          <Link to="/casosSucesso">Casos de sucesso</Link>
        </li>
        <li className={styles.navItem}>
          <Link to="/parcerias">Parcerias</Link>
        </li>
      </ul>
      <div className={styles.navbarActions}>
        <Link
          to="/login"
          className={`${styles.actionButton} ${styles.loginButton}`}
        >
          Entrar
        </Link>
        <Link
          to="/register"
          className={`${styles.actionButton} ${styles.signupButton}`}
        >
          Cadastre-se
        </Link>
      </div>
    </nav>
  );
}
