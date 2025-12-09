package com.include.inovale.landingpage.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario_confirmacao")
public class UsuarioConfirmacaoEntity {
    @Id
    @GeneratedValue
    private UUID id;
    
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private UsuarioEntity usuario;
    
    @Column(nullable = false)
    private String codigo;
    
    @Column(nullable = false)
    private LocalDateTime dataExpiracao;
}
