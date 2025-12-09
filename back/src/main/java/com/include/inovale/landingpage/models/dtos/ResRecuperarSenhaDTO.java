package com.include.inovale.landingpage.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResRecuperarSenhaDTO {
    @NotBlank
    private String email;
}
