import React from "react";
import styles from "./Button.module.css";
export default function Button({ onClick, children }) {
    return (
        <div className={styles.buttoncontainer} onClick={onClick}>
            <button type="submit" className={styles.button}>
                    Login
            </button>

        </div>
    );
}