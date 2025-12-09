package com.include.inovale.landingpage.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GmailAPIUser")
public class GmailAPIUserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String clientId;
    private String clientSecret;
    private String refreshToken;
    private String userEmail; 
}
