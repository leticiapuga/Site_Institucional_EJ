package com.include.inovale.landingpage.models.repositories;

import com.include.inovale.landingpage.models.entities.ServicoEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, UUID> {
}