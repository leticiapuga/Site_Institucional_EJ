import React, { useState } from "react";
import styles from "./DashboardLayout.module.css";
import logo from "../../assets/logo_inovale.svg";

interface DashboardLayoutProps {
  title: string;
  tabs: string[];
  renderContent: (activeTab: string) => React.ReactNode;
}

export default function DashboardLayout({
  title,
  tabs,
  renderContent,
}: DashboardLayoutProps) {
  const [activeTab, setActiveTab] = useState(tabs[0]);
  return (
    <div className={styles.dashboardContainer}>
      <aside className={styles.sidebar}>
        <img src={logo} alt="Logo" className={styles.imglogo}/>
        <nav>
          <ul>
            <li>
              
              <a href="/admin/services">Serviços</a>
            </li>
            <li>
              <a href="/admin/members">Membros</a>
            </li>
            <li>
              <a href="/admin/partnerships">Parcerias</a>
            </li>
            <li>
              <a href="/admin/success-cases">Casos de sucesso</a>
            </li>
            <li>
              <a href="/admin/messages">Mensagens</a>
            </li>
          </ul>
        </nav>
      </aside>
      <main className={styles.mainContent}>
        <header className={styles.topbar}>{title}</header>
        <div className={styles.tabs}>
          {tabs.map((tab) => (
            <button
              key={tab}
              className={activeTab === tab ? styles.activeTab : styles.tab}
              onClick={() => setActiveTab(tab)}
            >
              {tab}
            </button>
          ))}
        </div>
        <section className={styles.contentArea}>
          {renderContent(activeTab)}
        </section>
      </main>
    </div>
  );
}
