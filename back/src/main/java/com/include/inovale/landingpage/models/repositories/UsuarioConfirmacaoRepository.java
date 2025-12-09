package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.UsuarioConfirmacaoEntity;
import com.include.inovale.landingpage.models.entities.UsuarioEntity;

public interface UsuarioConfirmacaoRepository extends JpaRepository<UsuarioConfirmacaoEntity, UUID>{
    UsuarioConfirmacaoEntity findByCodigo(String codigo);
    UsuarioConfirmacaoEntity findByUsuario(UsuarioEntity usuario);

}
