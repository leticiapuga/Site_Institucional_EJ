package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.RecuperacaoSenhaEntity;

public interface RecuperacaoSenhaRepository extends JpaRepository<RecuperacaoSenhaEntity, UUID> {
    RecuperacaoSenhaEntity findByCodigo(String codigo);
    RecuperacaoSenhaEntity findByUsuarioId(UUID usuario);
}
