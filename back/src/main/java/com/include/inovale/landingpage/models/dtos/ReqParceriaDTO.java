package com.include.inovale.landingpage.models.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReqParceriaDTO {
    @NotBlank
    private String nomeEmpresa;

    @NotBlank
    private String logoUrl;
    private String siteUrl;

    @NotNull
    private LocalDate inicioParceria;
}