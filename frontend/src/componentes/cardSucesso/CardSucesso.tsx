import styles from "./CardSucesso.module.css";
import logo from "../../assets/logo_inovale.svg";

interface CasosSucessoItemProps {
    titulo: string;
    descricao: string;
    botaoTexto: string;
    imagemSrc: string; 
    onClick: () => void; 
}


const CardSucesso: React.FC<CasosSucessoItemProps> = ({
    titulo,
    descricao,
    botaoTexto,
    imagemSrc,
    onClick}) => {
  return (
    <div className={styles.card}>
        <img 
            src={imagemSrc} 
            alt={titulo} 
            className={styles.servicosImage} 
        /> 
        <div className={styles.tituloDescricao}>
            <h1>{titulo}</h1>
            <p>{descricao}</p>
        </div>
        <div className={styles.botao}>
            <button 
                className={styles.button} 
                onClick={onClick}
                >
                {botaoTexto}
            </button>
        </div>
    </div>
  );
}

export default CardSucesso;
