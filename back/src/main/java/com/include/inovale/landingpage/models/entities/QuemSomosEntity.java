package com.include.inovale.landingpage.models.entities; 

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membros_equipe")
public class QuemSomosEntity {

    @Id
    @GeneratedValue()
    private UUID id;

    private String nome;
    
    private String cargo; 
    private String fotoUrl; 
    
    private String linkedinUrl;
    
    private String githubUrl;
}