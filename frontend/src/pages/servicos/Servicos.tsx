import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import Navbar from "../../componentes/navbar/Navbar";
import styles from "./Servicos.module.css";
import ImageEstrutura from "../../assets/imageEstrutura.png"; 
import ServicoItem from "../../componentes/servicoItem/ServicoItem";
import Footer from '../../componentes/navbar/Footer';


interface ServicoData {
    id: number;
    titulo: string;
    descricao: string;
    imagemSrc: string; 
}

const mockServicos: ServicoData[] = [
    {
        id: 1,
        titulo: "Estruturação Financeira",
        descricao: "Ideal para empresas que buscam estruturar suas finanças de forma estratégica, essa solução oferece controle do fluxo de caixa, separação entre contas pessoais e empresariais e suporte à tomada de decisões mais seguras. Com uma gestão financeira organizada, o negócio ganha previsibilidade e cria bases para um crescimento sustentável.",
        imagemSrc: ImageEstrutura,
    },
    {
        id: 2,
        titulo: "Consultoria em Engenharia",
        descricao: "Análise detalhada do seu modelo de negócio para identificar gargalos e oportunidades de crescimento. Garanta que cada decisão contribua para seus objetivos de longo prazo na indústria mecânica.",
        imagemSrc: ImageEstrutura,
    },
    {
        id: 3,
        titulo: "Desenvolvimento de Produtos",
        descricao: "Transformamos suas ideias em produtos viáveis, aplicando design thinking e técnicas avançadas de engenharia para otimizar a fabricação e a funcionalidade.",
        imagemSrc: ImageEstrutura,
    },
    {
        id: 4,
        titulo: "Gestão de Projetos Industriais",
        descricao: "Desde a concepção até a entrega, garantimos que seus projetos industriais sejam concluídos no prazo, dentro do orçamento e com o mais alto padrão de qualidade.",
        imagemSrc: ImageEstrutura,
    },
];


function Servicos() {

    const [servicos, setServicos] = useState<ServicoData[]>([]);

    const handleButtonClick = (servicoId: number) => {
        window.location.href = `/faleconosco?servico=${servicoId}`;
    };

    useEffect(() => {
        setTimeout(() => {
            setServicos(mockServicos); 
        }, 500); 
    }, []); 
    
    if (servicos.length === 0) {
        return (
            <div className={styles.servicosContainer}>
                <Navbar />
                <div className={styles.conhecerContainer}>
                    <h1>Conheça nossos Serviços</h1>
                    <p> Oferecemos a você soluções em Engenharia Mecânica voltadas para a indústria...</p>
                </div>
                <div className={styles.servicosList}>
                    <p>Carregando serviços...</p>
                </div>
            </div>
        );
    }
    
    // 4. Renderização
    return (
        <div>
            <div className={styles.servicosContainer}>
                <Navbar />
                <div className={styles.conhecerContainer}>
                    <h1>Conheça nossos Serviços</h1>
                    <p> Oferecemos a você soluções em Engenharia Mecânica voltadas para a indústria, unindo técnica, eficiência e inovação. Atuamos no desenvolvimento e melhoria de processos, equipamentos e produtos, sempre buscando aumentar a produtividade e reduzir custos operacionais.</p>
                </div>

                <div className={styles.servicosList}>
                    {servicos.map((servico, index) => (
                        <ServicoItem
                            key={servico.id}
                            titulo={servico.titulo}
                            descricao={servico.descricao}
                            botaoTexto="Saiba mais"
                            imagemSrc={servico.imagemSrc}
                            
                            imagemEsquerda={index % 2 !== 0} 
                            
                            onClick={() => handleButtonClick(servico.id)} 
                        />
                    ))}
                </div>
                
            </div>
            <Footer/>
        </div>
        
    );
}

export default Servicos;