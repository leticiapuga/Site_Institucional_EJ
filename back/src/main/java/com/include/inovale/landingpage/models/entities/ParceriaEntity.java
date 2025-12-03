package com.include.inovale.landingpage.models.entities;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parceria")
public class ParceriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nomeEmpresa;
    private String logoUrl;
    private String siteUrl;
}