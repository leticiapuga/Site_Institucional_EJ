package com.include.inovale.landingpage.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import com.include.inovale.landingpage.models.entities.EmailEntity;
import com.include.inovale.landingpage.models.entities.GmailAPIUserEntity;
import com.include.inovale.landingpage.models.repositories.EmailRepository;
import com.include.inovale.landingpage.models.repositories.GmailAPIUserRepository;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import jakarta.mail.Session;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailRepository emailRepository;

    @Transactional
    public boolean enviarEmail(EmailEntity emailEntity){

        try {
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage mimeMessage = new MimeMessage(session);

            // 2. Usa o Helper para preencher os dados (UTF-8 e Multipart ativados)
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            // Pega o cliente atualizado do banco
            Gmail gmail = createGmailClient();
            
            MimeMessageHelper email = new MimeMessageHelper(mimeMessage, true, "utf-8");

            email.setFrom(new InternetAddress("me"));
            
            email.setTo(emailEntity.getDestinatario().getEmail());
            
            email.setSubject(emailEntity.getAsunto());

            email.setText(emailEntity.getMensagem(), true);


            // Converte para o formato Base64Url que o Gmail exige
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
             mimeMessage.writeTo(buffer); 
            
            byte[] rawMessageBytes = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);

            Message message = new Message();
            message.setRaw(encodedEmail);

            gmail.users().messages().send("me", message).execute();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage(), e);
        }
    
        
        emailRepository.save(emailEntity);

        return true;
    }

    private final GmailAPIUserRepository repository;
    
    // --- CORREÇÃO 2: Instanciação direta (new GsonFactory) ---
    private static final JsonFactory JSON_FACTORY = new GsonFactory();
    
    private static NetHttpTransport HTTP_TRANSPORT;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (Exception e) {
            e.printStackTrace();
            // Em produção, considere lançar uma ExceptionInInitializerError ou usar Logger
        }
    }

    // --- MÉTODO QUE CRIA O CLIENTE COM DADOS DO BANCO ---
    private Gmail createGmailClient() throws GeneralSecurityException, IOException {
        GmailAPIUserEntity creds = repository.findTopBy();

        if (creds == null) {
            throw new RuntimeException("Nenhuma credencial do Gmail configurada no banco de dados!");
        }

        // Montar a credencial dinamicamente
        Credential credential = new GoogleCredential.Builder()
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setClientSecrets(creds.getClientId(), creds.getClientSecret())
                .build()
                .setRefreshToken(creds.getRefreshToken());
 
        return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName("Inovale Sender App")
                .build();
    }

}
