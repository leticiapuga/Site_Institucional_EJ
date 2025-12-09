package com.include.inovale.landingpage.contollers;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.include.inovale.landingpage.services.AdminConfigService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/gmail")
public class GmailAuthController {

    private final AdminConfigService adminConfigService; // Serviço que criamos no passo anterior

    @Value("${app.google.client.id}")
    private String clientId;

    @Value("${app.google.client.secret}")
    private String clientSecret;

    @Value("${app.google.redirect.uri}")
    private String redirectUri;

    // Escopo necessário para enviar e-mails
    private static final List<String> SCOPES = Collections.singletonList("https://www.googleapis.com/auth/gmail.send");

    public GmailAuthController(AdminConfigService adminConfigService) {
        this.adminConfigService = adminConfigService;
    }
    @GetMapping("/login")
    public ResponseEntity<String> getAuthUrl() throws Exception {
        GoogleAuthorizationCodeFlow flow = getFlow();
        
        String authorizationUrl = flow.newAuthorizationUrl()
                .setRedirectUri(redirectUri)
                .setAccessType("offline")
                .setApprovalPrompt("force")
                .build();

        // Retorna a URL como JSON (ou String simples)
        return ResponseEntity.ok(authorizationUrl);
    }


    
    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String code) {
        try {
            GoogleAuthorizationCodeFlow flow = getFlow();

            // Troca o código de autorização pelos tokens (Access + Refresh)
            GoogleTokenResponse response = flow.newTokenRequest(code)
                    .setRedirectUri(redirectUri)
                    .execute();

            String refreshToken = response.getRefreshToken();
            
            // O Google as vezes não manda o email no Token Response,
           
            String email = "email-recuperado@google.com";

            if (refreshToken == null) {
                return ResponseEntity.badRequest().body("Erro: O Google não retornou um Refresh Token. Revogue o acesso e tente novamente.");
            }

            // SALVA NO BANCO DE DADOS AUTOMATICAMENTE
            adminConfigService.atualizarCredenciais(clientId, clientSecret, refreshToken, email);

            return ResponseEntity.ok("Sucesso! A conta foi vinculada e os e-mails serão enviados por ela.");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao trocar token com o Google: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
        }
    }

    // Método auxiliar para construir o fluxo
    private GoogleAuthorizationCodeFlow getFlow() throws Exception {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new GoogleAuthorizationCodeFlow.Builder(
                httpTransport,
                GsonFactory.getDefaultInstance(),
                clientId,
                clientSecret,
                SCOPES)
                .setAccessType("offline")
                .build();
    }
}