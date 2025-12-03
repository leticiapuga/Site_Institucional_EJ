import styles from "./Footer.module.css"
import { FiInstagram } from "react-icons/fi";
import { FaLinkedin } from "react-icons/fa";
import { FaRegEnvelope } from "react-icons/fa";
import { BsTelephone } from "react-icons/bs";
import resumo from "../../assets/resumoInovale.png";
import { Link } from "react-router-dom";


export default function Footer(){
    return(
        <div className={styles.rodape}>
            <div className={styles.nomeLogo}>
                <div className={styles.logo}>
                    <img src={resumo} alt="Logo" />
                </div>
            </div>



            <div className={styles.importante}>
                <div className={styles.Navegacao}>
                    <div className={styles.nav}>
                        <p>Navegaçao Rápida</p>
                    </div>
                        <div className={styles.inicio}>
                            <Link to="/">
                                 Inicio
                            </Link>
                        </div>
                    <div className={styles.servicos}>
                        <Link to="/servicos">
                                 Servicos
                            </Link>
                    </div>
                    <div className={styles.membros}>
                        <Link to="/membros">
                                 Membros
                            </Link>
                    </div>
                    <div className={styles.casosSucesso}>
                        <Link to="/casosDeSucesso">
                                 Servicos
                            </Link>
                    </div>
                    <div className={styles.Parcerias}>
                        <Link to="/parceirias">
                                 Servicos
                            </Link>
                    </div>
                </div>
                <div className={styles.informacoes}>
                    <div className={styles.redes}>
                        <p>Contatos</p>
                    </div>
                    <div className={styles.instagran}>
                        <FiInstagram/>
                        <p>@inovale</p>
                    </div>
                    <div className={styles.linkedin}>
                        <FaLinkedin/>
                        <p>Incllud jr</p>
                    </div>
                    <div className={styles.contato}>
                        <FaRegEnvelope/>
                        <p>includ@gmail.com</p>
                    </div>
                    <div className={styles.telefone}>
                        <BsTelephone/>
                        <p>(88)94002-8922</p>
                    </div>
                </div>
                <div className={styles.endereco}>
                    <div className= {styles.nomeEndereco}>
                        <p>Endereco</p>
                    </div>
                    <div>
                        <p>Na UFC Campus Russas</p>
                    </div>
                </div>
            </div>
                
        </div>
    );
}    