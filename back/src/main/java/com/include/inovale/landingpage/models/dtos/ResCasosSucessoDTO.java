package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;
import lombok.Data;

@Data
public class ResCasosSucessoDTO {
    private UUID id;
    

    private String nomeProjeto;
    private String cliente;
    private String descricaoSolucao;
    private String depoimentoCliente;
    private String imagemUrl;

    // devolvendo o nome do serviço relacionado
    private String nomeServico;
}