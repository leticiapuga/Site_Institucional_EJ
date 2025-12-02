package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReqRecuperarSenhaDTO {
    @NotBlank
    private String codigo;

    @Size(min=4)
    private String senha;
}
