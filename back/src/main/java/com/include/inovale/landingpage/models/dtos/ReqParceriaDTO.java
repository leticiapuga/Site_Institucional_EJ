package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReqParceriaDTO {
    @NotBlank
    private String nomeEmpresa;
    private String logoUrl;
    private String siteUrl;
}