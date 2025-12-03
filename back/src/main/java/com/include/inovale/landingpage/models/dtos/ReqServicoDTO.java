package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReqServicoDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;
    private String imagemUrl;
}