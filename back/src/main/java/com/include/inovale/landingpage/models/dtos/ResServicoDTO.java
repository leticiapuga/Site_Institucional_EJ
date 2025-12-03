package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ResServicoDTO{
    private UUID id;
    private String titulo;
    private String descricao;
    private String imagemUrl;
}