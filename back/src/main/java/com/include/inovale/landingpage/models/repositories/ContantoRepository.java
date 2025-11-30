package com.include.inovale.landingpage.models.repositories;

import com.include.inovale.landingpage.models.entities.ContantoEntity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContantoRepository extends JpaRepository<ContantoEntity, UUID> {
}
