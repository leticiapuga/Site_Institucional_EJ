import styles from "./CardParceiro.module.css";
import logo from "../../assets/logo_inovale.svg";

interface ParceirosItemProps {
    titulo: string;
    descricao: string;
    botaoTexto: string;
    imagemSrc: string; 
    onClick: () => void; 
}

const CardParceiro: React.FC<ParceirosItemProps> = ({
    titulo,
    descricao,
    imagemSrc,
    onClick}) => {

  return (
    <div className={styles.cardParceiro}>
        <img 
            src={imagemSrc}
            className={styles.cardImage} 
        />
        <h1>{titulo}</h1>
        <p>{descricao}</p>
    </div>
  );
}

export default CardParceiro;