package com.include.inovale.landingpage.models.entities;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cases_sucesso")
public class CasosSucesoEntity { // O nome da classe tem que ser igual ao arquivo (Suceso)

    @Id
    @GeneratedValue()
    private UUID id;

    private String nomeProjeto;
    
    private String cliente;

    @Column(columnDefinition = "TEXT")
    private String descricaoSolucao;
    
    @Column(columnDefinition = "TEXT")
    private String depoimentoCliente;

    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "servico_id") 
    private ServicoEntity servico;
}