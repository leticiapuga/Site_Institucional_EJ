package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResQuemSomosDTO {
    @NotNull
    private UUID id;
    private String nome;
    
    private String cargo; 
    private String fotoUrl; 
    
    private String linkedinUrl;
    
    private String githubUrl;
}