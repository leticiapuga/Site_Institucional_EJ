package com.include.inovale.landingpage.models.entities;

import java.util.UUID;

import com.include.inovale.landingpage.models.enums.PapelEnum;
import com.include.inovale.landingpage.models.enums.UsuarioEstadoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UsuarioEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UsuarioEstadoEnum estadoUsuario;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PapelEnum papel;

    @OneToOne(
        mappedBy = "usuario",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    
    private UsuarioConfirmacaoEntity confirmacao;
    
}
