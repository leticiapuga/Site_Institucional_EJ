import DashboardLayout from "../../componentes/dashboard/DashboardLayout";
import styles from "./ServicesAdmin.module.css";
import { useState } from "react";

interface Service {
  id: number;
  title: string;
  description: string;
  image: string;
}

// Mock para simular serviços cadastrados
const mockServices: Service[] = [
  {
    id: 1,
    title: "Estruturação Financeira",
    description:
      "Controle do fluxo de caixa, separação entre contas pessoais e empresariais e suporte à tomada de decisões mais seguras.",
    image: "https://via.placeholder.com/150",
  },
  {
    id: 2,
    title: "Consultoria em Engenharia",
    description:
      "Análise detalhada do seu modelo de negócio para identificar gargalos e oportunidades de crescimento.",
    image: "https://via.placeholder.com/150",
  },
];

export default function ServicesAdmin() {
  const [services, setServices] = useState<Service[]>(mockServices);
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState({
    title: "",
    description: "",
    image: "",
  });

  // Preenche o formulário ao selecionar um serviço
  function handleSelectEdit(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = Number(e.target.value);
    setSelectedId(id);
    const service = services.find((s) => s.id === id);
    if (service) {
      setEditForm({
        title: service.title,
        description: service.description,
        image: service.image,
      });
    }
  }

  // Atualiza campos do formulário de edição
  function handleEditChange(
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    setEditForm({ ...editForm, [e.target.name]: e.target.value });
  }

  // Salva edição
  function handleEditSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setServices((prev) =>
      prev.map((s) => (s.id === selectedId ? { ...s, ...editForm } : s))
    );
    alert("Serviço editado com sucesso!");
  }

  // Remove serviço
  function handleRemove(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setServices((prev) => prev.filter((s) => s.id !== selectedId));
    setSelectedId(null);
    alert("Serviço removido com sucesso!");
  }

  return (
    <DashboardLayout
      title="Serviços"
      tabs={["Adicionar", "Editar", "Remover"]}
      renderContent={(tab) => {
        if (tab === "Adicionar") {
          return (
            <form className={styles.form}>
              <label>Título</label>
              <input type="text" placeholder="Digite o título do serviço" />
              <label>Descrição</label>
              <textarea placeholder="Digite a descrição do serviço" />
              <label>Imagem</label>
              <input type="text" placeholder="Digite a URL da imagem" />
              <button className={styles.button}>Adicionar</button>
            </form>
          );
        }
        if (tab === "Editar") {
          return (
            <form className={styles.form} onSubmit={handleEditSubmit}>
              <label>Serviços</label>
              <select value={selectedId ?? ""} onChange={handleSelectEdit}>
                <option value="">Selecione um serviço</option>
                {services.map((service) => (
                  <option key={service.id} value={service.id}>
                    {service.title}
                  </option>
                ))}
              </select>
              {selectedId && (
                <>
                  <label>Título</label>
                  <input
                    type="text"
                    name="title"
                    value={editForm.title}
                    onChange={handleEditChange}
                    placeholder="Editar título do serviço"
                  />
                  <label>Descrição</label>
                  <textarea
                    name="description"
                    value={editForm.description}
                    onChange={handleEditChange}
                    placeholder="Editar descrição do serviço"
                  />
                  <label>Imagem</label>
                  <input
                    type="text"
                    name="image"
                    value={editForm.image}
                    onChange={handleEditChange}
                    placeholder="Editar URL da imagem"
                  />
                  <button className={styles.button} type="submit">
                    Salvar
                  </button>
                </>
              )}
            </form>
          );
        }
        if (tab === "Remover") {
          const selectedService = services.find((s) => s.id === selectedId);
          return (
            <form className={styles.form} onSubmit={handleRemove}>
              <label>Serviços</label>
              <select
                value={selectedId ?? ""}
                onChange={(e) => setSelectedId(Number(e.target.value))}
              >
                <option value="">Selecione um serviço</option>
                {services.map((service) => (
                  <option key={service.id} value={service.id}>
                    {service.title}
                  </option>
                ))}
              </select>
              {selectedService && (
                <div
                  style={{
                    background: "#f2f2f2",
                    borderRadius: 12,
                    boxShadow: "0 2px 8px rgba(0,0,0,0.08)",
                    padding: 32,
                    margin: "32px auto 0 auto",
                    display: "flex",
                    flexDirection: "column",
                    alignItems: "center",
                    maxWidth: 500,
                  }}
                >
                  <h2
                    style={{
                      color: "#0c3845",
                      fontSize: "1.2rem",
                      fontWeight: 600,
                      marginBottom: 12,
                      textAlign: "center",
                    }}
                  >
                    {selectedService.title}
                  </h2>
                  <p
                    style={{
                      color: "#0c3845",
                      fontSize: "1rem",
                      marginBottom: 18,
                      textAlign: "center",
                    }}
                  >
                    {selectedService.description}
                  </p>
                  <img
                    src={selectedService.image}
                    alt={selectedService.title}
                    style={{
                      width: 170,
                      height: 110,
                      objectFit: "cover",
                      borderRadius: 8,
                      marginBottom: 24,
                      boxShadow: "0 2px 8px rgba(0,0,0,0.08)",
                    }}
                  />
                  <button
                    className={styles.button}
                    type="submit"
                    style={{ width: 140 }}
                  >
                    Remover
                  </button>
                </div>
              )}
            </form>
          );
        }
        return null;
      }}
    />
  );
}
