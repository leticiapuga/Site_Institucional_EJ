package com.include.inovale.landingpage.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "emails_log")
public class EmailEntity {
    @Id
    @GeneratedValue
    private UUID id;
    
    @Column(nullable = false)
    private String remetente = "System";
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private UsuarioEntity destinatario;
    
    @Column(nullable = false)
    private String asunto;
    
    @Column(nullable = false, length = 8000)
    private String mensagem;
}