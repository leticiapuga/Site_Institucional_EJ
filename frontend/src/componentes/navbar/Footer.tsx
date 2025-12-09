import styles from "./Footer.module.css";
import logo from "../../assets/logo_login_e_cadastro.png";
import { Link } from "react-router-dom";
import { FiInstagram, FiPhone } from "react-icons/fi";
import { FaLinkedin, FaRegEnvelope } from "react-icons/fa";

export default function Footer() {
  return (
    <footer className={styles.footer}>
      <div className={styles.logoSection}>
        <img src={logo} alt="Logo Inovale Jr" className={styles.logo} />
      </div>
      <div className={styles.column}>
        <h3 className={styles.title}>Navegação rápida</h3>
        <ul className={styles.list}>
          <li>
            <Link to="/" className={styles.link}>
              Início
            </Link>
          </li>
          <li>
            <Link to="/servicos" className={styles.link}>
              Serviços
            </Link>
          </li>
          <li>
            <Link to="/nossosMembros" className={styles.link}>
              Nossos membros
            </Link>
          </li>
          <li>
            <Link to="/casosDeSucesso" className={styles.link}>
              Casos de sucesso
            </Link>
          </li>
          <li>
            <Link to="/parcerias" className={styles.link}>
              Parcerias
            </Link>
          </li>
        </ul>
      </div>
      <div className={styles.column}>
        <h3 className={styles.title}>Contatos</h3>
        <ul className={styles.list}>
          <li>
            <a
              href="https://instagram.com/inovalejr"
              target="_blank"
              rel="noopener noreferrer"
              className={styles.link}
            >
              <FiInstagram className={styles.icon} /> @inovalejr
            </a>
          </li>
          <li>
            <a
              href="https://linkedin.com/company/inovale-jr"
              target="_blank"
              rel="noopener noreferrer"
              className={styles.link}
            >
              <FaLinkedin className={styles.icon} /> Inovale Jr
            </a>
          </li>
          <li>
            <a href="mailto:contato@inovalejr.com.br" className={styles.link}>
              <FaRegEnvelope className={styles.icon} /> contato@inovalejr.com.br
            </a>
          </li>
          <li>
            <a href="tel:+5585998340717" className={styles.link}>
              <FiPhone className={styles.icon} /> (85) 99834-0717
            </a>
          </li>
        </ul>
      </div>
      <div className={styles.column}>
        <h3 className={styles.title}>Endereço</h3>
        <ul className={styles.list}>
          <li>Bloco Universitário</li>
          <li>
            Av. Coronel Araújo Lima,
            <br />
            Sala 02, Russas - CE
          </li>
          <li>629000000, BR</li>
        </ul>
      </div>
    </footer>
  );
}
