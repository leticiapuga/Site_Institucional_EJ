package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReqQuemSomosDTO {
    @NotBlank
    private String nome;
    
    @NotBlank
    private String cargo; 
    private String fotoUrl; 
    
    private String linkedinUrl;
    
    private String githubUrl;
}