import DashboardLayout from "../../componentes/dashboard/DashboardLayout";
import styles from "./MessagesAdmin.module.css";
import { useState } from "react";

interface Message {
  id: number;
  name: string;
  email: string;
  phone: string;
  content: string;
}

const mockMessages: Message[] = [
  {
    id: 1,
    name: "João Silva",
    email: "joao@email.com",
    phone: "(85) 99999-9999",
    content: "Mensagem do cliente mensagem do cliente mensagem do cliente...",
  },
  {
    id: 2,
    name: "Maria Souza",
    email: "maria@email.com",
    phone: "(85) 98888-8888",
    content: "Outra mensagem do cliente...",
  },
];

export default function MessagesAdmin() {
  const [messages] = useState<Message[]>(mockMessages);
  const [selectedId, setSelectedId] = useState<number | null>(null);

  return (
    <DashboardLayout
      title="Mensagens"
      tabs={["Visualizar"]}
      renderContent={() => {
        const selectedMessage = messages.find((m) => m.id === selectedId);
        return (
          <form className={styles.form}>
            <label>Mensagens</label>
            <select
              value={selectedId ?? ""}
              onChange={(e) => setSelectedId(Number(e.target.value))}
            >
              <option value="">Selecione uma mensagem para responder</option>
              {messages.map((m) => (
                <option key={m.id} value={m.id}>
                  {m.name}
                </option>
              ))}
            </select>
            {selectedMessage && (
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
                  {selectedMessage.name}
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
                  {selectedMessage.email}
                </h3>
                <p
                  style={{
                    color: "#0c3845",
                    fontSize: "1rem",
                    marginBottom: 8,
                    textAlign: "center",
                  }}
                >
                  {selectedMessage.phone}
                </p>
                <p
                  style={{
                    color: "#0c3845",
                    fontSize: "0.98rem",
                    marginBottom: 18,
                    textAlign: "center",
                  }}
                >
                  {selectedMessage.content}
                </p>
                <button
                  className={styles.button}
                  type="button"
                  style={{ width: 220 }}
                  onClick={() =>
                    window.open(`mailto:${selectedMessage.email}`, "_blank")
                  }
                >
                  Responder via e-mail
                </button>
              </div>
            )}
          </form>
        );
      }}
    />
  );
}
