package com.include.inovale.landingpage.services;

import org.springframework.stereotype.Service;

import com.include.inovale.landingpage.models.entities.GmailAPIUserEntity;
import com.include.inovale.landingpage.models.repositories.GmailAPIUserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminConfigService {

    private final GmailAPIUserRepository repository;

    
    public GmailAPIUserEntity getCredentials() {
        return repository.findTopBy();
    }

    @Transactional
    public void atualizarCredenciais(String clientId, String clientSecret, String refreshToken, String email) {
        GmailAPIUserEntity entity = repository.findTopBy();

        if (entity == null) {
            entity = new GmailAPIUserEntity();
        }

        entity.setClientId(clientId);
        entity.setClientSecret(clientSecret);
        entity.setRefreshToken(refreshToken);
        entity.setUserEmail(email);

        repository.save(entity);
    }

}
