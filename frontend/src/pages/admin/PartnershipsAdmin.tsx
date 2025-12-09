import DashboardLayout from "../../componentes/dashboard/DashboardLayout";
import styles from "./PartnershipsAdmin.module.css";
import { useState } from "react";

interface Partnership {
  id: number;
  company: string;
  year: string;
  site: string;
  image: string;
}

const mockPartnerships: Partnership[] = [
  {
    id: 1,
    company: "Empresa A",
    year: "2023",
    site: "https://empresaA.com",
    image: "https://via.placeholder.com/150",
  },
  {
    id: 2,
    company: "Empresa B",
    year: "2020",
    site: "https://empresaB.com",
    image: "https://via.placeholder.com/150",
  },
];

export default function PartnershipsAdmin() {
  const [partnerships, setPartnerships] =
    useState<Partnership[]>(mockPartnerships);
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState({
    company: "",
    year: "",
    site: "",
    image: "",
  });

  function handleSelectEdit(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = Number(e.target.value);
    setSelectedId(id);
    const partnership = partnerships.find((p) => p.id === id);
    if (partnership) {
      setEditForm({
        company: partnership.company,
        year: partnership.year,
        site: partnership.site,
        image: partnership.image,
      });
    }
  }

  function handleEditChange(e: React.ChangeEvent<HTMLInputElement>) {
    setEditForm({ ...editForm, [e.target.name]: e.target.value });
  }

  function handleEditSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setPartnerships((prev) =>
      prev.map((p) => (p.id === selectedId ? { ...p, ...editForm } : p))
    );
    alert("Parceria editada com sucesso!");
  }

  function handleRemove(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setPartnerships((prev) => prev.filter((p) => p.id !== selectedId));
    setSelectedId(null);
    alert("Parceria removida com sucesso!");
  }

  return (
    <DashboardLayout
      title="Parcerias"
      tabs={["Adicionar", "Editar", "Remover"]}
      renderContent={(tab) => {
        if (tab === "Adicionar") {
          return (
            <form className={styles.form}>
              <label>Empresa</label>
              <input
                type="text"
                placeholder="Digite o nome da empresa parceira"
              />
              <label>Ano de início</label>
              <input
                type="text"
                placeholder="Digite o ano de início da parceria"
              />
              <label>Site da empresa</label>
              <input
                type="text"
                placeholder="Digite a url do site da empresa parceira"
              />
              <label>Imagem</label>
              <input
                type="text"
                placeholder="Digite a url da logo da empresa"
              />
              <button className={styles.button}>Adicionar</button>
            </form>
          );
        }
        if (tab === "Editar") {
          return (
            <form className={styles.form} onSubmit={handleEditSubmit}>
              <label>Parcerias</label>
              <select value={selectedId ?? ""} onChange={handleSelectEdit}>
                <option value="">Selecione uma empresa parceira</option>
                {partnerships.map((p) => (
                  <option key={p.id} value={p.id}>
                    {p.company}
                  </option>
                ))}
              </select>
              {selectedId && (
                <>
                  <label>Empresa</label>
                  <input
                    type="text"
                    name="company"
                    value={editForm.company}
                    onChange={handleEditChange}
                    placeholder="Editar nome da empresa parceira"
                  />
                  <label>Ano de início</label>
                  <input
                    type="text"
                    name="year"
                    value={editForm.year}
                    onChange={handleEditChange}
                    placeholder="Editar ano de início da parceria"
                  />
                  <label>Site da empresa</label>
                  <input
                    type="text"
                    name="site"
                    value={editForm.site}
                    onChange={handleEditChange}
                    placeholder="Editar url do site da empresa parceira"
                  />
                  <label>Imagem</label>
                  <input
                    type="text"
                    name="image"
                    value={editForm.image}
                    onChange={handleEditChange}
                    placeholder="Editar url da logo da empresa"
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
          const selectedPartnership = partnerships.find(
            (p) => p.id === selectedId
          );
          return (
            <form className={styles.form} onSubmit={handleRemove}>
              <label>Parcerias</label>
              <select
                value={selectedId ?? ""}
                onChange={(e) => setSelectedId(Number(e.target.value))}
              >
                <option value="">Selecione uma empresa parceira</option>
                {partnerships.map((p) => (
                  <option key={p.id} value={p.id}>
                    {p.company}
                  </option>
                ))}
              </select>
              {selectedPartnership && (
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
                    {selectedPartnership.company}
                  </h2>
                  <p
                    style={{
                      color: "#0c3845",
                      fontSize: "1rem",
                      marginBottom: 8,
                      textAlign: "center",
                    }}
                  >
                    Ano de início da parceria: {selectedPartnership.year}
                  </p>
                  <p
                    style={{
                      color: "#0c3845",
                      fontSize: "1rem",
                      marginBottom: 8,
                      textAlign: "center",
                    }}
                  >
                    Site: {selectedPartnership.site}
                  </p>
                  <img
                    src={selectedPartnership.image}
                    alt={selectedPartnership.company}
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
