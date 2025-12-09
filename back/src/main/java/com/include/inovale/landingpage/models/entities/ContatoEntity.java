package com.include.inovale.landingpage.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID; 

@Data
@Entity
@Table(name = "contatos_fale_conosco")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera o UUID sozinho
    private UUID id; 

    private String nome;
    private String email;
    private String telefone;
    
    @Column(columnDefinition = "TEXT")
    private String mensagem;
    
    private LocalDateTime dataEnvio;
    private boolean lido;
}