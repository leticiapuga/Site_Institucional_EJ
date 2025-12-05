import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";
import styles from "./Members.module.css";

export default function Members() {
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

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Diretores</h2>
          <div className={styles.cardsGrid}>
            <div className={styles.card}>
              <span className={styles.name}>Sarah Vitória</span>
              <span className={styles.role}>VPGG</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Maria Eduarda</span>
              <span className={styles.role}>Comercial</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Gustavo Barros</span>
              <span className={styles.role}>Projetos</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Coordenadores</h2>
          <div className={styles.cardsGrid}>
            <div className={styles.card}>
              <span className={styles.name}>Ana Cecília</span>
              <span className={styles.role}>Marketing</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Sara Queiroz</span>
              <span className={styles.role}>Projetos</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Ana Letícia</span>
              <span className={styles.role}>Experiência do Cliente</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Gerentes de Projetos</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Arthur Alves</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Antônio Marcelo</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Gestores da Presidência</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Liana Souza</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Isabelly Lima</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Diogo Victor</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>
            Assessores de Gestão de Pessoas
          </h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Carlos David</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Maria Izabel</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Assessores do Adm. Financeiro</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Lucas Kauã</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Liana Souza</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Analistas de Marketing</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Maria Isabele</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Hellen</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Consultoras de Vendas</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Ana Clara</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Mirelly</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>
            Assessora de Experiência do Cliente
          </h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Patrícia</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>

        <div className={styles.section}>
          <h2 className={styles.sectionTitle}>Analistas de P&amp;D</h2>
          <div className={styles.cardsRow}>
            <div className={styles.card}>
              <span className={styles.name}>Gabrielly Oliveira</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Antônio Marcelo</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Isabelly Lima</span>
              <span className={styles.role}>Em análise</span>
            </div>
            <div className={styles.card}>
              <span className={styles.name}>Yan Lopes</span>
              <span className={styles.role}>Em análise</span>
            </div>
          </div>
        </div>
      </section>
      <Footer />
    </div>
  );
}
