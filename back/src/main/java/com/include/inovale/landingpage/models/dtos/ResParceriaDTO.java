package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;
import lombok.Data;

@Data
public class ResParceriaDTO {
    private UUID id;
    private String nomeEmpresa;
    private String logoUrl;
    private String siteUrl;
}