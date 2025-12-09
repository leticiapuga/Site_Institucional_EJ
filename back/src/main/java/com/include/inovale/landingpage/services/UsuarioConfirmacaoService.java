package com.include.inovale.landingpage.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.emailsResource.ConfirmacaoEmail;
import com.include.inovale.landingpage.models.entities.EmailEntity;
import com.include.inovale.landingpage.models.entities.UsuarioConfirmacaoEntity;
import com.include.inovale.landingpage.models.entities.UsuarioEntity;
import com.include.inovale.landingpage.models.enums.UsuarioEstadoEnum;
import com.include.inovale.landingpage.models.mappers.UsuarioMapper;
import com.include.inovale.landingpage.models.repositories.EmailRepository;
import com.include.inovale.landingpage.models.repositories.UsuarioConfirmacaoRepository;
import com.include.inovale.landingpage.models.repositories.UsuarioRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioConfirmacaoService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioConfirmacaoRepository usuarioConfirmacaoRepository;
    private final ConfirmacaoEmail confirmacaoEmail;
    private final EmailRepository emailRepository;
    private final EmailService emailService;
    private final int TEMPO_EXPIRACAO_PADRAO_HORAS = 24;


    public boolean confirmarCriacaoUsuario(UsuarioEntity usuarioEntity){
        
        if (usuarioEntity.getEstadoUsuario() != UsuarioEstadoEnum.PENDENTE){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Usuário já confirmado"
            );
        }

        UsuarioConfirmacaoEntity usuarioConfirmacao = usuarioConfirmacaoRepository.findByUsuario(usuarioEntity);

        if( usuarioConfirmacao == null ) usuarioConfirmacao = new UsuarioConfirmacaoEntity();
        
        usuarioConfirmacao.setUsuario(usuarioEntity);
        usuarioConfirmacao.setDataExpiracao(
            LocalDateTime.now().plusHours(TEMPO_EXPIRACAO_PADRAO_HORAS)
        );
        usuarioConfirmacao.setCodigo(gerarCodigoConfirmacao());
        // EXIBIR CÓDIGO NO TERMINAL PARA NÃO TER QUE ABRIR O E-MAIL
        // System.out.println(usuarioConfirmacao.getCodigo());

        // AVISANDO O USUÁRIO O CÓDIGO PARA CONFIRMAR O SEU E-MAIL
        EmailEntity email = new EmailEntity();
        email.setAsunto("Confirmar E-mail");
        email.setDestinatario(usuarioEntity);
        email.setMensagem(confirmacaoEmail.gerarMensagemEmail(
            usuarioConfirmacao.getCodigo(), usuarioEntity.getNome()
            )
        );
        try {
            usuarioConfirmacaoRepository.save(usuarioConfirmacao);
            emailService.enviarEmail(email);
            emailRepository.save(email);
        } catch (Exception e) {
            System.out.println("Erro ao gerar a confirmação de e-mail\n" + e);
        }


        return true;
    }

    private String gerarCodigoConfirmacao(){
        // PEGA OS OITO CARACTERES DE UM CÓDGO UUID ALEATORIO
        String codigo = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        
        return codigo;
    }

    public ResRegistrarUsuarioDTO confirmarUsuario(String codigo){
        UsuarioConfirmacaoEntity usuarioConfirmacao;
        usuarioConfirmacao = usuarioConfirmacaoRepository.findByCodigo(codigo);

        if(usuarioConfirmacao == null){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Não há usuário que corresponde a esse código!"
            );
        }

        if (usuarioConfirmacao.getDataExpiracao().isBefore(LocalDateTime.now())){
            UsuarioEntity usuarioEntity = usuarioConfirmacao.getUsuario();
            usuarioEntity.setConfirmacao(null);
            usuarioRepository.save(usuarioEntity);
            usuarioConfirmacaoRepository.deleteById(usuarioConfirmacao.getId());

            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "O código expirou!"
            );
        }

        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioConfirmacao.getUsuario().getId()).get();
        usuarioEntity.setEstadoUsuario(UsuarioEstadoEnum.ATIVO);
        usuarioRepository.save(usuarioEntity);

        usuarioEntity.setConfirmacao(null);
        usuarioRepository.save(usuarioEntity);
        usuarioConfirmacaoRepository.deleteById(usuarioConfirmacao.getId());

        return usuarioMapper.entityToResRegistrarUsuarioDTO(usuarioEntity);
    }
    
}