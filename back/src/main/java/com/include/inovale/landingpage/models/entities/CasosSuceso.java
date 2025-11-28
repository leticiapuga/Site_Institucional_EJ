package com.include.inovale.landingpage.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cases_sucesso")
public class CasosSuceso { // O nome da classe tem que ser igual ao arquivo (Suceso)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProjeto;
    
    private String cliente;

    @Column(columnDefinition = "TEXT")
    private String descricaoSolucao;
    
    @Column(columnDefinition = "TEXT")
    private String depoimentoCliente;

    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "servico_id") 
    private Servico servico;
}