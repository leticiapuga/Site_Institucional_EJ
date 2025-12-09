
import Navbar from "../../componentes/navbar/Navbar";
import styles from "./CasosSucesso.module.css";
import Footer from "../../componentes/navbar/Footer";
import CardSucesso from "../../componentes/cardSucesso/cardSucesso";
import logo from "../../assets/logo_inovale.svg";

function CasosSucesso() {
  const handleButtonClick = () => {
    window.location.href = '/faleconosco';
  };
  return (
    <div className={styles.casosCotainer}>
        <Navbar />

        <h1>Conheça nossos casos de sucesso</h1>
        <p>Desde 2016, a Inovale atua transformando empresas do Vale do Jaguaribe com soluções inovadoras e de impacto, visando o desenvolvimento de micro, pequenos e médios Empreendedores</p>

        <div className={styles.casosSucessoContainer}>
            <div>
              <h1>Desenho de impressão 3D</h1>
              <CardSucesso
                titulo="Atlética Indomável"
                descricao="A Atlética Indomável escolheu a Inovale Jr para seu projeto de Impressão 3D, e entregamos uma solução inovadora com excelência e 100% de satisfação do cliente!"
                botaoTexto="Saiba mais"
                imagemSrc={logo}
                onClick={handleButtonClick} />

              <h1>Planejamento estratégico</h1>
              <CardSucesso
                titulo="Eita! Xocolate"
                descricao="A Eita! Xocolate confiou à Inovale Jr para alavancar o seu negócio com o projeto de Planejamento Estratégico, e entregamos com excelência, obtendo 100% de satisfação do cliente!"
                botaoTexto="Saiba mais"
                imagemSrc={logo}
                onClick={handleButtonClick} />

              <h1>Análise de custos</h1>
              <CardSucesso
                titulo="Com afeto, Mocinha"
                descricao="A Com Afeto, Mocinha confiou à Inovale Jr sua Análise de Custos, criando soluções que que aumentaram a eficiência e impulsionaram seu sucesso, obtendo 100% de satisfação do cliente."
                botaoTexto="Saiba mais"
                imagemSrc={logo}
                onClick={handleButtonClick} />

              <h1>Estruturação Financeira</h1>
              <CardSucesso
                titulo="Barbearia Sev7n"
                descricao="A Barbearia Sev7n confiou à Inovale Jr a Estruturação Financeira, e juntos implementamos soluções para mais controle e crescimento do se negócio, alcançando 100% de satisfação do cliente!"
                botaoTexto="Saiba mais"
                imagemSrc={logo}
                onClick={handleButtonClick} />
            </div>
        </div>
        <Footer/>
    </div>
  );
}

export default CasosSucesso;