import styles from "./CardParceiro.module.css";

interface ParceiroProps {
  titulo: string;
  descricao: string;
  imagemSrc: string;
}

const CardParceiro: React.FC<ParceiroProps> = ({
  titulo,
  descricao,
  imagemSrc,
}) => {
  return (
    <div className={styles.cardParceiro}>
      <img src={imagemSrc} className={styles.cardImage} alt={titulo} />
      <h1>{titulo}</h1>
      <p>{descricao}</p>
    </div>
  );
};

export default CardParceiro;
