package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.include.inovale.landingpage.models.entities.ParceriaEntity;

@Repository
public interface ParceriaRepository extends JpaRepository<ParceriaEntity, UUID> {
}