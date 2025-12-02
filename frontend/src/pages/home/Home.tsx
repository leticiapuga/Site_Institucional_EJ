import React from "react";
import {Link} from 'react-router-dom';
import Navbar from "../../componentes/navbar/Navbar";
import styles from "./Home.module.css";

function Home() {
  return (
    <div>
        <Navbar />

        <div className={styles.homeContainer}>
            <h1>Welcome to the Home Page</h1>
        </div>
    </div>
  );
}

export default Home;