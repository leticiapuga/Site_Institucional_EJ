package com.include.inovale.landingpage.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contatos_fale_conosco")
public class ContantoEntity { // Nome igual ao arquivo dele

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    
    private LocalDateTime dataEnvio = LocalDateTime.now(); 
    private boolean lido = false; 
}