import DashboardLayout from "../../componentes/dashboard/DashboardLayout";
import styles from "./SuccessCasesAdmin.module.css";
import { useState } from "react";

interface SuccessCase {
  id: number;
  project: string;
  company: string;
  description: string;
  image: string;
}

const mockCases: SuccessCase[] = [
  {
    id: 1,
    project: "Nome do projeto implementado",
    company: "Nome da empresa",
    description:
      "Descrição do caso de sucesso descrição do caso de sucesso descrição do caso de sucesso descrição do caso de sucesso...",
    image: "https://via.placeholder.com/150",
  },
  {
    id: 2,
    project: "Outro projeto",
    company: "Empresa B",
    description: "Outro caso de sucesso...",
    image: "https://via.placeholder.com/150",
  },
];

export default function SuccessCasesAdmin() {
  const [cases, setCases] = useState<SuccessCase[]>(mockCases);
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState({
    project: "",
    company: "",
    description: "",
    image: "",
  });

  function handleSelectEdit(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = Number(e.target.value);
    setSelectedId(id);
    const successCase = cases.find((c) => c.id === id);
    if (successCase) {
      setEditForm({
        project: successCase.project,
        company: successCase.company,
        description: successCase.description,
        image: successCase.image,
      });
    }
  }

  function handleEditChange(
    e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) {
    setEditForm({ ...editForm, [e.target.name]: e.target.value });
  }

  function handleEditSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setCases((prev) =>
      prev.map((c) => (c.id === selectedId ? { ...c, ...editForm } : c))
    );
    alert("Caso de sucesso editado com sucesso!");
  }

  function handleRemove(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setCases((prev) => prev.filter((c) => c.id !== selectedId));
    setSelectedId(null);
    alert("Caso de sucesso removido com sucesso!");
  }

  return (
    <DashboardLayout
      title="Casos de sucesso"
      tabs={["Adicionar", "Editar", "Remover"]}
      renderContent={(tab) => {
        if (tab === "Adicionar") {
          return (
            <form className={styles.form}>
              <label>Projeto</label>
              <input
                type="text"
                placeholder="Digite o nome do projeto implementado"
              />
              <label>Empresa</label>
              <input type="text" placeholder="Digite o nome da empresa" />
              <label>Descrição</label>
              <textarea placeholder="Digite uma descrição para o caso de sucesso" />
              <label>Imagem</label>
              <input
                type="text"
                placeholder="Digite a url da imagem associada ao caso de sucesso"
              />
              <button className={styles.button}>Adicionar</button>
            </form>
          );
        }
        if (tab === "Editar") {
          return (
            <form className={styles.form} onSubmit={handleEditSubmit}>
              <label>Casos de sucesso</label>
              <select value={selectedId ?? ""} onChange={handleSelectEdit}>
                <option value="">Selecione um caso de sucesso</option>
                {cases.map((c) => (
                  <option key={c.id} value={c.id}>
                    {c.project}
                  </option>
                ))}
              </select>
              {selectedId && (
                <>
                  <label>Projeto</label>
                  <input
                    type="text"
                    name="project"
                    value={editForm.project}
                    onChange={handleEditChange}
                    placeholder="Editar nome do projeto implementado"
                  />
                  <label>Empresa</label>
                  <input
                    type="text"
                    name="company"
                    value={editForm.company}
                    onChange={handleEditChange}
                    placeholder="Editar nome da empresa"
                  />
                  <label>Descrição</label>
                  <textarea
                    name="description"
                    value={editForm.description}
                    onChange={handleEditChange}
                    placeholder="Editar descrição do caso de sucesso"
                  />
                  <label>Imagem</label>
                  <input
                    type="text"
                    name="image"
                    value={editForm.image}
                    onChange={handleEditChange}
                    placeholder="Editar url da imagem associada ao caso de sucesso"
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
          const selectedCase = cases.find((c) => c.id === selectedId);
          return (
            <form className={styles.form} onSubmit={handleRemove}>
              <label>Casos de sucesso</label>
              <select
                value={selectedId ?? ""}
                onChange={(e) => setSelectedId(Number(e.target.value))}
              >
                <option value="">Selecione um caso de sucesso</option>
                {cases.map((c) => (
                  <option key={c.id} value={c.id}>
                    {c.project}
                  </option>
                ))}
              </select>
              {selectedCase && (
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
                      fontSize: "1.15rem",
                      fontWeight: 600,
                      marginBottom: 10,
                      textAlign: "center",
                    }}
                  >
                    {selectedCase.project}
                  </h2>
                  <h3
                    style={{
                      color: "#0c3845",
                      fontSize: "1rem",
                      fontWeight: 500,
                      marginBottom: 8,
                      textAlign: "center",
                    }}
                  >
                    {selectedCase.company}
                  </h3>
                  <p
                    style={{
                      color: "#0c3845",
                      fontSize: "0.98rem",
                      marginBottom: 18,
                      textAlign: "center",
                    }}
                  >
                    {selectedCase.description}
                  </p>
                  <img
                    src={selectedCase.image}
                    alt={selectedCase.project}
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
