package com.include.inovale.landingpage.models.entities; 

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membros_equipe")
public class QuemSomos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    private String cargo; 
    private String fotoUrl; 
    
    private String linkedinUrl;
    
    private String githubUrl;
}