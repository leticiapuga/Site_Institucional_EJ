package com.include.inovale.landingpage.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "servicos")
public class ServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String imagemUrl;

    // Relacionamento com Cases (Um serviço tem vários cases)
    @OneToMany(mappedBy = "servico") 
    private List<CasosSucesoEntity> cases; 
}