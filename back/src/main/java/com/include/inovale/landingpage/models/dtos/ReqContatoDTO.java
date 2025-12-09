package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqContatoDTO {
    @NotBlank
    private String nome;

    @Email
    private String email;

    private String telefone;

    @NotBlank
    private String mensagem;
}