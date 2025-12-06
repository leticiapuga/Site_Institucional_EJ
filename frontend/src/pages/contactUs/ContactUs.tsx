import styles from "./ContactUs.module.css";
import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";
import equipeInovale from "../../assets/equipe_inovale.png";

export default function ContactUs() {
  return (
    <div>
      <Navbar />
      <div className={styles.container}>
        <h2 className={styles.title}>Fale conosco</h2>
        <p className={styles.subtitle}>
          Precisa de suporte, informações ou quer solicitar um orçamento? Envie
          sua mensagem e nossa equipe <br /> retornará o mais rápido possível.
        </p>
        <div className={styles.formWrapper}>
          <div className={styles.imageArea}>
            <img
              src={equipeInovale}
              alt="Equipe Inovale"
              className={styles.imageEquipe}
            />
          </div>
          <form className={styles.form}>
            <div className={styles.formFields}>
              <label htmlFor="name" className={styles.label}>
                Nome completo
              </label>
              <input
                type="text"
                id="name"
                placeholder="Digite seu nome"
                className={styles.input}
                required
              />

              <label htmlFor="email" className={styles.label}>
                E-mail
              </label>
              <input
                type="email"
                id="email"
                placeholder="Seu e-mail"
                className={styles.input}
                required
              />

              <label htmlFor="phone" className={styles.label}>
                Telefone
              </label>
              <input
                type="tel"
                id="phone"
                placeholder="Seu telefone (opcional)"
                className={styles.input}
              />

              <label htmlFor="message" className={styles.label}>
                Como podemos ajudar você?
              </label>
              <textarea
                id="message"
                placeholder="Digite sua mensagem"
                className={styles.textarea}
                required
              />
            </div>
            <button type="submit" className={styles.button}>
              Enviar
            </button>
          </form>
        </div>
      </div>
      <Footer />
    </div>
  );
}
