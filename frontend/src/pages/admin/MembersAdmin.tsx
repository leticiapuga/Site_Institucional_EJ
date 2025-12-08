import DashboardLayout from "../../componentes/dashboard/DashboardLayout";
import styles from "./MembersAdmin.module.css";
import { useState } from "react";

interface Member {
  id: number;
  name: string;
  role: string;
}

const mockMembers: Member[] = [
  { id: 1, name: "Sarah Vitória", role: "VPGG" },
  { id: 2, name: "Maria Eduarda", role: "Comercial" },
  { id: 3, name: "Gustavo Barros", role: "Projetos" },
];

export default function MembersAdmin() {
  const [members, setMembers] = useState<Member[]>(mockMembers);
  const [selectedId, setSelectedId] = useState<number | null>(null);
  const [editForm, setEditForm] = useState({ name: "", role: "" });

  // Preenche o formulário ao selecionar um membro
  function handleSelectEdit(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = Number(e.target.value);
    setSelectedId(id);
    const member = members.find((m) => m.id === id);
    if (member) {
      setEditForm({ name: member.name, role: member.role });
    }
  }

  // Atualiza campos do formulário de edição
  function handleEditChange(e: React.ChangeEvent<HTMLInputElement>) {
    setEditForm({ ...editForm, [e.target.name]: e.target.value });
  }

  // Salva edição
  function handleEditSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setMembers((prev) =>
      prev.map((m) => (m.id === selectedId ? { ...m, ...editForm } : m))
    );
    alert("Membro editado com sucesso!");
  }

  // Remove membro
  function handleRemove(e: React.FormEvent) {
    e.preventDefault();
    if (selectedId === null) return;
    setMembers((prev) => prev.filter((m) => m.id !== selectedId));
    setSelectedId(null);
    alert("Membro removido com sucesso!");
  }

  return (
    <DashboardLayout
      title="Membros"
      tabs={["Adicionar", "Editar", "Remover"]}
      renderContent={(tab) => {
        if (tab === "Adicionar") {
          return (
            <form className={styles.form}>
              <label>Nome</label>
              <input type="text" placeholder="Digite o nome do membro" />
              <label>Setor</label>
              <input
                type="text"
                placeholder="Digite o setor do qual o membro faz parte"
              />
              <button className={styles.button}>Adicionar</button>
            </form>
          );
        }
        if (tab === "Editar") {
          return (
            <form className={styles.form} onSubmit={handleEditSubmit}>
              <label>Membros</label>
              <select value={selectedId ?? ""} onChange={handleSelectEdit}>
                <option value="">Selecione um membro da equipe</option>
                {members.map((member) => (
                  <option key={member.id} value={member.id}>
                    {member.name}
                  </option>
                ))}
              </select>
              {selectedId && (
                <>
                  <label>Nome</label>
                  <input
                    type="text"
                    name="name"
                    value={editForm.name}
                    onChange={handleEditChange}
                    placeholder="Editar nome do membro"
                  />
                  <label>Setor</label>
                  <input
                    type="text"
                    name="role"
                    value={editForm.role}
                    onChange={handleEditChange}
                    placeholder="Editar setor do membro"
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
          const selectedMember = members.find((m) => m.id === selectedId);
          return (
            <form className={styles.form} onSubmit={handleRemove}>
              <label>Membros</label>
              <select
                value={selectedId ?? ""}
                onChange={(e) => setSelectedId(Number(e.target.value))}
              >
                <option value="">Selecione um membro da equipe</option>
                {members.map((member) => (
                  <option key={member.id} value={member.id}>
                    {member.name}
                  </option>
                ))}
              </select>
              {selectedMember && (
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
                    {selectedMember.name}
                  </h2>
                  <p
                    style={{
                      color: "#0c3845",
                      fontSize: "1rem",
                      marginBottom: 18,
                      textAlign: "center",
                    }}
                  >
                    {selectedMember.role}
                  </p>
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
