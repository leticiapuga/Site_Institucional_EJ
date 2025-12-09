package com.include.inovale.landingpage.models.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReqRegistrarUsuarioDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @Size(min = 8, max = 64, message = "A senha deve ter entre 8 e 64 caracteres")
    @Pattern(
    regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%&*_\\-.])[A-Za-z\\d!@#$%&*_\\-.]{8,64}$",
    message = "A senha deve ter entre 8 e 64 caracteres, conter maiúscula, minúscula, número e especial (!@#$%&*_-.)."
)
    private String senha;
}
