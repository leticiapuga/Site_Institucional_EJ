package com.include.inovale.landingpage.models.emailsResource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ConfirmacaoEmail {
    @Value("${url.base}")
    private String urlbase;

    public String gerarMensagemEmail(String codigo, String nomeUsuario){
        // A URL BASE TEM O CARACTERE "/" NO FIM
        String linkrecuperacao = urlbase + "/auth/validar/" + codigo;

        String mensagem = String.format(
        """
            <p>Olá %s,</p>
            <p>Por favor, use o código <b>%s</b> ou clique no botão abaixo para confirmar o seu e-mail:</p>
            <a href="%s">
            <p style="display:inline-block;padding:12px 22px;border-radius:6px;text-decoration:none;font-weight:600;background:#0d6efd;color:#ffffff;">%s</p></a>
            
            <p>Se você não solicitou, ignore esta mensagem.</p>

            """, nomeUsuario, codigo, linkrecuperacao, linkrecuperacao);

        return mensagem;
    }
}
