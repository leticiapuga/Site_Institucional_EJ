package com.include.inovale.landingpage.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID; 

@Data // 
@Entity
@Table(name = "servico")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // 

    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    private String imagemUrl;
}