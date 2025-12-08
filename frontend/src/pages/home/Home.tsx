import styles from "./Home.module.css";
import imageInclude from "../../assets/imageInclude.png";
import iconeMissao from "../../assets/iconeMissao.png";
import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";

function Home() {
  return (
    <div className={styles.homeContainer}>
        <Navbar />
        
        <div className={styles.sessaoContainer} >
              <h1>INOVALE</h1>
              <p>Transformando ideias em soluções reais através da inovação e excelência</p>
              <button className={styles.buttonHome} onClick={() => {window.location.href = '/faleconosco'}}>Conheça nossa missão, visão e valores</button>
        </div>
        <div
          className={styles.sessaoSobreNos}
          style={{
            backgroundImage: `
              linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
              url(${imageInclude})
            `
          }}
          >
            <h1>Sobre Nós</h1>
            <div className={styles.textoSobreNos}>
              <p>
                Somos a Inovale, uma Empresa Júnior vinculada à Universidade Federal do Ceará - Campus Russas,
                comprometida em entregar soluções inovadoras e desenvolver futuros profissionais de excelência.
              </p>
            </div>
        </div>

        <div className={styles.sessaoMissaoVisaoValores}>
            <div className={styles.textoDescricao}>
                <h1>Conheça nossa missão visão e valores</h1>
                <p>
                Na Inovale Jr, acreditamos na força do empreendedorismo, na busca contínua por excelência e na construção de uma cultura que impulsiona nossos membros a irem além. Nossa essência é guiada por propósito, visão de futuro e princípios que fortalecem nossas entregas e nossa união enquanto equipe. É a partir dessa base que orientamos cada projeto, cada decisão e cada resultado que buscamos gerar.
                </p>
            </div>
            <div className={styles.missaoContainer}>
              <h1>Missão</h1>
              <div className={styles.descricaoMissao}>
                  <img src={iconeMissao} alt="Ícone Missão" className={styles.iconeMissao} />
                  <p>
                    Potencializar o ambiente empreendedor no Ceará e promover uma vivência empresarial valiosa para os membros da empresa.
                  </p>
              </div>
              
            </div>
            <div className={styles.missaoContainer}>
              <h1>Visão</h1>
              <div className={styles.descricaoMissao}>
                  <img src={iconeMissao} alt="Ícone Missão" className={styles.iconeMissao} />
                  <p>
                    Tornar a Inovale referência em consultoria empresarial no Ceará e no MEJ, com soluções de alto impacto.                  
                  </p>
              </div>
              
            </div>
            <div className={styles.missaoContainer}>
              <h1>Valores</h1>
              <div className={styles.descricaoValores}>
                  <img src={iconeMissao} alt="Ícone Missão" className={styles.iconeMissao} />
                  <div>
                    <p>- Senso de dono</p>
                    <p>- Inconformismo</p>
                    <p>- Espírito de alfa</p>
                  </div>
                  <div>
                    <p>- Constancia de resultados</p>
                    <p>- Ser alcateia</p>
                  </div>
              </div>
              
            </div>
    
        </div>
        <Footer/>
    </div>
  );
}

export default Home;