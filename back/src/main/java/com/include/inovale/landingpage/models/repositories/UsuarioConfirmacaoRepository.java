package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.UsuarioConfirmacaoEntity;

public interface UsuarioConfirmacaoRepository extends JpaRepository<UsuarioConfirmacaoEntity, UUID>{
    UsuarioConfirmacaoEntity findByCodigo(String codigo);
}
