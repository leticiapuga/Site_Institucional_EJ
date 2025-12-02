package com.include.inovale.landingpage.models.repositories;

import com.include.inovale.landingpage.models.entities.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID; 

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, UUID> {
}