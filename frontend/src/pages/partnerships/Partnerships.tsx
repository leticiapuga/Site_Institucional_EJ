
import Navbar from "../../componentes/navbar/Navbar";
import styles from "./Partnerships.module.css";
import Footer from "../../componentes/navbar/Footer";
import logo from "../../assets/logo_inovale.svg";
import CardParceiro from "../../componentes/cardParceiro/CardParceiro";

function Partnerships() {
  return (
    <div className={styles.partnerCotainer}>
        <Navbar />

        <h1>Conheça nossos parceiros</h1>
        <p>Nossas parcerias são construídas com base em confiança, colaboração e resultados. Trabalhamos lado a lado com empresas, instituições e organizações que acreditam no potencial da inovação e da engenharia para transformar realidades. Cada parceria amplia nosso impacto, fortalece nossa atuação no mercado e possibilita a criação de soluções que geram valor para toda a comunidade.</p>

        <div className={styles.partnershipsContainer}>
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2023"
            imagemSrc={logo}/> 
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2020"
            imagemSrc={logo}/>
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2019"
            imagemSrc={logo}/>  
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2019"
            imagemSrc={logo}/> 
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2023"
            imagemSrc={logo}/>
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2020"
            imagemSrc={logo}/>   
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2019"
            imagemSrc={logo}/> 
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2023"
            imagemSrc={logo}/>
          <CardParceiro
            titulo="Empresa"
            descricao="Parceiros desde 2020"
            imagemSrc={logo}/> 
        </div>
        <Footer/>
    </div>
  );
}

export default Partnerships;