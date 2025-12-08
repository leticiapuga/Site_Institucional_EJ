import { useEffect, useState } from "react";
import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";
import styles from "./Partnerships.module.css";
import CardParceiro from "../../componentes/cardParceiro/CardParceiro";
import logoInovale from "../../assets/logo_inovale.svg";

interface Parceiro {
  id: number;
  titulo: string;
  descricao: string;
  imagemSrc: string;
}

export default function Partnerships() {
  const [parceiros, setParceiros] = useState<Parceiro[]>([]);

  useEffect(() => {
    setTimeout(() => {
      setParceiros([
        {
          id: 1,
          titulo: "Empresa",
          descricao: "Parceiros desde 2023",
          imagemSrc: logoInovale,
        },
        {
          id: 2,
          titulo: "Empresa",
          descricao: "Parceiros desde 2020",
          imagemSrc: logoInovale,
        },
        {
          id: 3,
          titulo: "Empresa",
          descricao: "Parceiros desde 2019",
          imagemSrc: logoInovale,
        },
        {
          id: 4,
          titulo: "Empresa",
          descricao: "Parceiros desde 2019",
          imagemSrc: logoInovale,
        },
        {
          id: 5,
          titulo: "Empresa",
          descricao: "Parceiros desde 2023",
          imagemSrc: logoInovale,
        },
        {
          id: 6,
          titulo: "Empresa",
          descricao: "Parceiros desde 2020",
          imagemSrc: logoInovale,
        },
        {
          id: 7,
          titulo: "Empresa",
          descricao: "Parceiros desde 2019",
          imagemSrc: logoInovale,
        },
        {
          id: 8,
          titulo: "Empresa",
          descricao: "Parceiros desde 2023",
          imagemSrc: logoInovale,
        },
        {
          id: 9,
          titulo: "Empresa",
          descricao: "Parceiros desde 2020",
          imagemSrc: logoInovale,
        },
      ]);
    }, 500);
  }, []);

  return (
    <div className={styles.page}>
      <Navbar />
      <div className={styles.container}>
        <h1 className={styles.title}>Conheça nossos parceiros</h1>
        <p className={styles.subtitle}>
          Nossas parcerias são construídas com base em confiança, colaboração e
          resultados. Trabalhamos lado a lado com empresas, instituições e
          organizações que acreditam no potencial da inovação e da engenharia
          para transformar realidades. Cada parceria amplia nosso impacto,
          fortalece nossa atuação no mercado e possibilita a criação de soluções
          que geram valor para toda a comunidade.
        </p>
        <div className={styles.grid}>
          {parceiros.map((parceiro) => (
            <CardParceiro
              key={parceiro.id}
              titulo={parceiro.titulo}
              descricao={parceiro.descricao}
              imagemSrc={parceiro.imagemSrc}
            />
          ))}
        </div>
      </div>
      <Footer />
    </div>
  );
}
