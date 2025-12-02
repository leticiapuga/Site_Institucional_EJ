package com.include.inovale.landingpage.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.include.inovale.landingpage.models.entities.EmailEntity;
import com.include.inovale.landingpage.models.repositories.EmailRepository;

import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    @Transactional
    public boolean enviarEmail(EmailEntity emailEntity){
        
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper email = new MimeMessageHelper(mimeMessage, true, "utf-8");

            email.setFrom(sender);
            
            email.setTo(emailEntity.getDestinatario().getEmail());
            
            email.setSubject(emailEntity.getAsunto());

            email.setText(emailEntity.getMensagem(), true);

            javaMailSender.send(mimeMessage);
        }
        catch(Exception e){
            System.out.println("Erro ao enviar email \n" + e);
        }
        
        emailRepository.save(emailEntity);

        return true;
    }
}
