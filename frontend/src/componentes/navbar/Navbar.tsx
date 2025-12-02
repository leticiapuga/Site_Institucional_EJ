import { Link } from "react-router-dom";
import styles from "./Navbar.module.css";


export default function Navbar() {
    return (
        <nav className={styles.navbar}>
            <ul className={styles.navList}>
                <li className={styles.navItem}>
                    <Link to="/">Home</Link>
                </li>
                <li className={styles.navItem}>
                    <Link to="/servicos">Serviços</Link>
                </li>
            </ul>
        </nav>
    );
}