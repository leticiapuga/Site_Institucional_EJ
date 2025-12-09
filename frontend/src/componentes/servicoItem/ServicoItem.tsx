import React from 'react';
import styles from './ServicoItem.module.css';


interface ServicoItemProps {
    titulo: string;
    descricao: string;
    botaoTexto: string;
    imagemSrc: string;
    onClick: () => void;
    
    imagemEsquerda?: boolean; 
}


const ServicoItem: React.FC<ServicoItemProps> = ({
    titulo,
    descricao,
    botaoTexto,
    imagemSrc,
    onClick,
 
    imagemEsquerda = false 
}) => {
    const inverterClasse = imagemEsquerda ? styles['inverter-ordem'] : '';
    const itemClasses = `${styles.servicoItem} ${inverterClasse}`;

    return (
        <div className={itemClasses}>
            
            
            <div className={styles.servicoTexto}>
                <h1>{titulo}</h1>
                <p>{descricao}</p>
                <button 
                    className={styles.buttonServico} 
                    onClick={onClick}
                >
                    {botaoTexto}
                </button>
            </div>

            <img 
                src={imagemSrc} 
                alt={titulo} 
                className={styles.servicosImage} 
            /> 
        </div>
    );
};

export default ServicoItem;