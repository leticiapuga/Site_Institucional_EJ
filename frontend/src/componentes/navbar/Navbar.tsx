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
                            <Link to="/inicio">Inicio</Link>
                        </li>
                        <li className={styles.navItem}>
                            <Link to="/servicos">Serviços</Link>
                        </li>
                        <li className={styles.navItem}>
                            <Link to="/nossosMembros">Nossos Membros</Link>
                        </li>
                        <li className={styles.navItem}>
                            <Link to="/faleConosco">Fale Conosco</Link>
                        </li>
                        <li className={styles.navItem}>
                            <Link to="/casosDeSucesso">Casos de Sucesso</Link>
                        </li>
                        <li className={styles.navItem}>
                            <Link to="/parceirias">Parceirias</Link>
                        </li>
                    </ul>
            <div className={styles.navbarActions}>
                <Link
                    to="/entrar"
                    className={`${styles.actionButton} ${styles.loginButton}`}
                >
                    Entrar
                </Link>
                <Link 
                    to="/cadastre-se" 
                    className={`${styles.actionButton} ${styles.signupButton}`}
                >
                    Cadastre-se
                </Link>
            </div>
        </nav>
    );
}