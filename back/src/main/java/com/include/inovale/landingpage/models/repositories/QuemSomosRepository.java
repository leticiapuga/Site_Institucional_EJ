package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.QuemSomosEntity;

public interface QuemSomosRepository extends JpaRepository<QuemSomosEntity, UUID>{
    
}
