package com.include.inovale.landingpage.models.emailsResource;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class RecuperacaoSenhaEmail {
    
    public String gerarMensagemEmail(String codigo, String nomeUsuario) {
        String mensagem = String.format(
        """
            <p>Olá %s,</p>
            <p>Recebemos sua solicitação para recuperação de senha.</p>
            <p>Use o código abaixo para criar uma nova senha:</p>
            <p style="display:inline-block;padding:12px 22px;border-radius:6px;text-decoration:none;font-weight:600;background:#dc3545;color:#ffffff;">%s</p>
            <p>Se você não fez essa solicitação, apenas ignore este e-mail.</p>
        """, nomeUsuario, codigo);

        return mensagem;
    }
}
