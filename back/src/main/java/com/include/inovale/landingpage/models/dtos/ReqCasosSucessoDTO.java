package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReqCasosSucessoDTO {
    @NotBlank
    private String nomeProjeto; 

    @NotBlank
    private String cliente;

    @NotBlank
    private String descricaoSolucao;

    @NotBlank
    private String depoimentoCliente;
    private String imagemUrl;

    @NotNull
    private UUID idServico;
}