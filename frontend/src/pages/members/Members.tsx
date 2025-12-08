import { useEffect, useState } from "react";
import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";
import styles from "./Members.module.css";

interface Member {
  id: number;
  nome: string;
  cargo: string;
  diretoria: string;
}

export default function Members() {
  const [members, setMembers] = useState<Member[]>([]);

  useEffect(() => {
    setTimeout(() => {
      setMembers([
        { id: 1, nome: "Sarah Vitória", cargo: "VPGG", diretoria: "Diretores" },
        {
          id: 2,
          nome: "Maria Eduarda",
          cargo: "Comercial",
          diretoria: "Diretores",
        },
        {
          id: 3,
          nome: "Gustavo Barros",
          cargo: "Projetos",
          diretoria: "Diretores",
        },
        {
          id: 4,
          nome: "Ana Cecília",
          cargo: "Marketing",
          diretoria: "Coordenadores",
        },
        {
          id: 5,
          nome: "Sara Queiroz",
          cargo: "Projetos",
          diretoria: "Coordenadores",
        },
        {
          id: 6,
          nome: "Ana Letícia",
          cargo: "Experiência do Cliente",
          diretoria: "Coordenadores",
        },
        {
          id: 7,
          nome: "Arthur Alves",
          cargo: "Em análise",
          diretoria: "Gerentes de Projetos",
        },
        {
          id: 8,
          nome: "Antônio Marcelo",
          cargo: "Em análise",
          diretoria: "Gerentes de Projetos",
        },
        {
          id: 9,
          nome: "Liana Souza",
          cargo: "Em análise",
          diretoria: "Gestores da Presidência",
        },
        {
          id: 10,
          nome: "Isabelly Lima",
          cargo: "Em análise",
          diretoria: "Gestores da Presidência",
        },
        {
          id: 11,
          nome: "Diogo Victor",
          cargo: "Em análise",
          diretoria: "Gestores da Presidência",
        },
        {
          id: 12,
          nome: "Carlos David",
          cargo: "Em análise",
          diretoria: "Assessores de Gestão de Pessoas",
        },
        {
          id: 13,
          nome: "Maria Izabel",
          cargo: "Em análise",
          diretoria: "Assessores de Gestão de Pessoas",
        },
        {
          id: 14,
          nome: "Lucas Kauã",
          cargo: "Em análise",
          diretoria: "Assessores do Adm. Financeiro",
        },
        {
          id: 15,
          nome: "Liana Souza",
          cargo: "Em análise",
          diretoria: "Assessores do Adm. Financeiro",
        },
        {
          id: 16,
          nome: "Maria Isabele",
          cargo: "Em análise",
          diretoria: "Analistas de Marketing",
        },
        {
          id: 17,
          nome: "Hellen",
          cargo: "Em análise",
          diretoria: "Analistas de Marketing",
        },
        {
          id: 18,
          nome: "Ana Clara",
          cargo: "Em análise",
          diretoria: "Consultoras de Vendas",
        },
        {
          id: 19,
          nome: "Mirelly",
          cargo: "Em análise",
          diretoria: "Consultoras de Vendas",
        },
        {
          id: 20,
          nome: "Patrícia",
          cargo: "Em análise",
          diretoria: "Assessora de Experiência do Cliente",
        },
        {
          id: 21,
          nome: "Gabrielly Oliveira",
          cargo: "Em análise",
          diretoria: "Analistas de P&D",
        },
        {
          id: 22,
          nome: "Antônio Marcelo",
          cargo: "Em análise",
          diretoria: "Analistas de P&D",
        },
        {
          id: 23,
          nome: "Isabelly Lima",
          cargo: "Em análise",
          diretoria: "Analistas de P&D",
        },
        {
          id: 24,
          nome: "Yan Lopes",
          cargo: "Em análise",
          diretoria: "Analistas de P&D",
        },
      ]);
    }, 500);
  }, []);

  const diretorias = [
    "Diretores",
    "Coordenadores",
    "Gerentes de Projetos",
    "Gestores da Presidência",
    "Assessores de Gestão de Pessoas",
    "Assessores do Adm. Financeiro",
    "Analistas de Marketing",
    "Consultoras de Vendas",
    "Assessora de Experiência do Cliente",
    "Analistas de P&D",
  ];

  return (
    <div className={styles.page}>
      <Navbar />
      <section className={styles.container}>
        <h1 className={styles.title}>Conheça nossos membros</h1>
        <p className={styles.subtitle}>
          Na Inovale, contamos com uma equipe dedicada, talentosa e apaixonada
          por Engenharia Mecânica e Engenharia de Produção. Trabalhamos de forma
          colaborativa para entregar soluções eficientes e inovadoras, unindo
          conhecimento técnico, criatividade e compromisso com resultados.
        </p>
        {diretorias.map((diretoria) => {
          const membrosDaDiretoria = members.filter(
            (m) => m.diretoria === diretoria
          );
          if (membrosDaDiretoria.length === 0) return null;
          // Se 1 ou 2 membros, centraliza com cardsRowCenter
          const isCenter =
            membrosDaDiretoria.length === 1 || membrosDaDiretoria.length === 2;
          return (
            <div className={styles.section} key={diretoria}>
              <h2 className={styles.sectionTitle}>{diretoria}</h2>
              <div
                className={isCenter ? styles.cardsRowCenter : styles.cardsGrid}
              >
                {membrosDaDiretoria.map((membro) => (
                  <div className={styles.card} key={membro.id}>
                    <span className={styles.name}>{membro.nome}</span>
                    <span className={styles.role}>{membro.cargo}</span>
                  </div>
                ))}
              </div>
            </div>
          );
        })}
      </section>
      <Footer />
    </div>
  );
}
