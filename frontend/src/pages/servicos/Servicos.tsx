import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import Navbar from "../../componentes/navbar/Navbar";
import styles from "./Servicos.module.css";
import ImageEstrutura from "../../assets/imageEstrutura.png";
import ServicoItem from "../../componentes/servicoItem/ServicoItem";
import Footer from "../../componentes/navbar/Footer";
import Analisecusto from "../../assets/analise_custo.png";
import Imgplanejamento from "../../assets/img_planejamento.png";
import Imgmapeamento from "../../assets/img_mapeamento.png";



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
    descricao:
      "Ideal para empresas que buscam estruturar suas finanças de forma estratégica, essa solução oferece controle do fluxo de caixa, separação entre contas pessoais e empresariais e suporte à tomada de decisões mais seguras. Com uma gestão financeira organizada, o negócio ganha previsibilidade e cria bases para um crescimento sustentável.",
    imagemSrc: ImageEstrutura,
  },
  {
    id: 2,
    titulo: "Análise de custos",
    descricao:
      "Ideal para negócios que buscam controle e monitoramento dos gastos, identificar onde e como os recursos estão sendo utilizados, reduzir desperdícios e aumentar a lucratividade. Essa solução também contribui para uma precificação mais assertiva dos produtos e decisões gerenciais mais eficientes.",
    imagemSrc: Analisecusto,
  },
  {
    id: 3,
    titulo: "Planejamento estratégico",
    descricao:
      "Apropriado para empresas que tem o objetivo de entender o seu posicionamento no mercado e que busca se destacar. O planejamento auxilia na tomada de decisão, desenvolvendo os recursos para alcançar suas estratégias.",
    imagemSrc: Imgplanejamento,
  },
  {
    id: 4,
    titulo: "Mapeamento de processos",
    descricao:
      "Ideal para empresas que buscam otimizar a operação, padronizar atividades e eliminar falhas. Essa solução traz mais eficiência, controle e clareza nos processos, reduzindo custos e identificando pontos de melhoria.",
    imagemSrc: Imgmapeamento,
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
          <p>
            {" "}
            Oferecemos a você soluções em Engenharia Mecânica voltadas para a
            indústria...
          </p>
        </div>
        <div className={styles.servicosList}>
          <p>Carregando serviços...</p>
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className={styles.servicosContainer}>
        <Navbar />
        <div className={styles.conhecerContainer}>
          <h1>Conheça nossos Serviços</h1>
          <p>
            {" "}
            Oferecemos a você soluções em Engenharia Mecânica voltadas para a
            indústria, unindo técnica, eficiência e inovação. Atuamos no
            desenvolvimento e melhoria de processos, equipamentos e produtos,
            sempre buscando aumentar a produtividade e reduzir custos
            operacionais.
          </p>
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
      <Footer />
    </div>
  );
}

export default Servicos;
