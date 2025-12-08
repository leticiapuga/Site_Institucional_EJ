import { useState } from "react";
import styles from "./ContactUs.module.css";
import Navbar from "../../componentes/navbar/Navbar";
import Footer from "../../componentes/navbar/Footer";
import equipeInovale from "../../assets/equipe_inovale.png";

export default function ContactUs() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    phone: "",
    message: "",
  });
  const [loading, setLoading] = useState(false);
  const [success, setSuccess] = useState(false);

  function handleChange(
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    setForm({ ...form, [e.target.name]: e.target.value });
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setLoading(true);
    setSuccess(false);
    try {
      const res = await fetch(" adicionar", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });
      if (res.ok) {
        setSuccess(true);
        setForm({ name: "", email: "", phone: "", message: "" });
      }
    } catch {
      setSuccess(false);
    } finally {
      setLoading(false);
    }
  }

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
          <form className={styles.form} onSubmit={handleSubmit}>
            <div className={styles.formFields}>
              <label htmlFor="name" className={styles.label}>
                Nome completo
              </label>
              <input
                type="text"
                id="name"
                name="name"
                placeholder="Digite seu nome"
                className={styles.input}
                required
                value={form.name}
                onChange={handleChange}
              />

              <label htmlFor="email" className={styles.label}>
                E-mail
              </label>
              <input
                type="email"
                id="email"
                name="email"
                placeholder="Seu e-mail"
                className={styles.input}
                required
                value={form.email}
                onChange={handleChange}
              />

              <label htmlFor="phone" className={styles.label}>
                Telefone
              </label>
              <input
                type="tel"
                id="phone"
                name="phone"
                placeholder="Seu telefone (opcional)"
                className={styles.input}
                value={form.phone}
                onChange={handleChange}
              />

              <label htmlFor="message" className={styles.label}>
                Como podemos ajudar você?
              </label>
              <textarea
                id="message"
                name="message"
                placeholder="Digite sua mensagem"
                className={styles.textarea}
                required
                value={form.message}
                onChange={handleChange}
              />
            </div>
            <button type="submit" className={styles.button} disabled={loading}>
              {loading ? "Enviando..." : "Enviar"}
            </button>
            {success && (
              <p style={{ color: "#0c3845", marginTop: "12px" }}>
                Mensagem enviada com sucesso!
              </p>
            )}
          </form>
        </div>
      </div>
      <Footer />
    </div>
  );
}
