package com.include.inovale.landingpage.models.dtos;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResLogarUsuarioDTO {
    private UUID id;

    private String nome;

    private String email;

    private String token;
}
