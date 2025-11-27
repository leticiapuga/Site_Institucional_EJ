package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID>{
    UsuarioEntity findByEmail(String email);
    
}
