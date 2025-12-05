package com.include.inovale.landingpage.models.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.include.inovale.landingpage.models.entities.GmailAPIUserEntity;

public interface GmailAPIUserRepository extends JpaRepository<GmailAPIUserEntity, UUID> {
    GmailAPIUserEntity findTopBy();
}
