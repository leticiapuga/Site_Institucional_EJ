package com.include.inovale.landingpage.models.emailsResource;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ConfirmacaoEmail {
    
    public String gerarMensagemEmail(String codigo, String nomeUsuario){
        String mensagem = String.format(
        """
            <p>Olá %s,</p>
            <p>Por favor, use o código abaixo para confirmar o sua e-mail:</p>
            <p style="display:inline-block;padding:12px 22px;border-radius:6px;text-decoration:none;font-weight:600;background:#0d6efd;color:#ffffff;">%s</p>
            <p>Se você não solicitou, ignore esta mensagem.</p>

            """, nomeUsuario, codigo);

        return mensagem;
    }
}
