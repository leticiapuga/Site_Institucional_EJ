package com.include.inovale.landingpage.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.dtos.ReqRecuperarSenhaDTO;
import com.include.inovale.landingpage.models.dtos.ResRecuperarSenhaDTO;
import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.emailsResource.RecuperacaoSenhaEmail;
import com.include.inovale.landingpage.models.entities.EmailEntity;
import com.include.inovale.landingpage.models.entities.RecuperacaoSenhaEntity;
import com.include.inovale.landingpage.models.entities.UsuarioEntity;
import com.include.inovale.landingpage.models.mappers.UsuarioMapper;
import com.include.inovale.landingpage.models.repositories.EmailRepository;
import com.include.inovale.landingpage.models.repositories.RecuperacaoSenhaRepository;
import com.include.inovale.landingpage.models.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RecuperacaoSenhaService {
    private final RecuperacaoSenhaRepository recuperacaoSenhaRepository;
    private final RecuperacaoSenhaEmail recuperacaoSenhaEmail;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailRepository emailRepository;
    private final UsuarioMapper usuarioMapper;
    private final EmailService emailService;

    private final int TEMPO_EXPIRACAO_HORAS = 2;

    public ResRecuperarSenhaDTO criarCogigoRecuperacao(ResRecuperarSenhaDTO dto){
        // VERIFICANDO SE O E-MAIL INFORMADO CORRESPONDE A UM USUÁRIO REGISTRADO
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioRepository.findByEmail(dto.getEmail());

        if (usuarioEntity == null) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Usuário não registrado na base de dados"
        );
        
        RecuperacaoSenhaEntity recuperacaoSenhaEntity = recuperacaoSenhaRepository.findByUsuarioId(usuarioEntity.getId());
        
        if ( null != recuperacaoSenhaEntity){
            // EXCLUINDO O CÓDIGO ANTIGO
            usuarioEntity.setRecuperarSenha(null);
            usuarioRepository.save(usuarioEntity);
            recuperacaoSenhaRepository.delete(recuperacaoSenhaEntity);
        }
        
        // CRIANDO O OBJETO QUE INDICA QUE O USUÁRIO QUER RECUPERAR A SENHA
        recuperacaoSenhaEntity = new RecuperacaoSenhaEntity();
        recuperacaoSenhaEntity.setCodigo(gerarCodigoRecuperacao());
        recuperacaoSenhaEntity.setDataExpiracao(
            LocalDateTime.now().plusHours(TEMPO_EXPIRACAO_HORAS)
        );
        recuperacaoSenhaEntity.setUsuario(usuarioEntity);

        // PREPARANDO E-MAIL COM O CÓDIGO
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setAsunto("Recuperar senha");
        emailEntity.setDestinatario(usuarioEntity);
        emailEntity.setMensagem(
            recuperacaoSenhaEmail.gerarMensagemEmail(
                recuperacaoSenhaEntity.getCodigo(), usuarioEntity.getNome()
                )
            );

        // ENVIANDO O EMAIL DE RECUPERAÇÃO E GUARDNANDO OS OBJETOS NO BANCO
        try {
            recuperacaoSenhaRepository.save(recuperacaoSenhaEntity);
            emailService.enviarEmail(emailEntity);
            emailRepository.save(emailEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "Houve um erro ao criar o código de recuperação"
            );
            
        }
        
        // CASO O TRY FUNCIONE E A TUDO OCORRA CONFORME O ESPERADO
        return dto;
    }

    public ResRegistrarUsuarioDTO mudarSenha(ReqRecuperarSenhaDTO dto){
        // BUSCANDO O USUÁRIO A PARTIR DO CÓDIOGO INFORMADO
        RecuperacaoSenhaEntity recuperacaoSenhaEntity = recuperacaoSenhaRepository.findByCodigo(dto.getCodigo());
        
        if (recuperacaoSenhaEntity == null) {
            throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "Não há usuário vinculado ao código informado"
            );
        }
        
        UsuarioEntity usuarioEntity = recuperacaoSenhaEntity.getUsuario();


        if (recuperacaoSenhaEntity.getDataExpiracao().isBefore(LocalDateTime.now())) {
            // EXCLUINDO O CÓDIGO EXPIRADO
            usuarioEntity.setRecuperarSenha(null);
            usuarioRepository.save(usuarioEntity);
            recuperacaoSenhaRepository.delete(recuperacaoSenhaEntity);

            // ENCERRANDO A EXECUÇÃO POR CONTA DO CÓDIGO EXPIRADO
            throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "Código expirado"
            );
        }

        // CRIPTOGRAFANDO A SENHA
        String senha = passwordEncoder.encode(dto.getSenha());
        
        // ATUALIZANDO A SENHA
        usuarioEntity.setSenha(senha);

        try {
            // PERSISTINDO AS MUDANÇAS NO BD
            usuarioEntity.setRecuperarSenha(null);
            usuarioRepository.save(usuarioEntity);
            recuperacaoSenhaRepository.delete(recuperacaoSenhaEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, 
            "ERRO AO SALVAR A NOVA SENHA"
            );
        }

        return usuarioMapper.entityToResRegistrarUsuarioDTO(usuarioEntity);
    }


    private String gerarCodigoRecuperacao(){
        // PEGA OS DEZ CARACTERES DE UM CÓDGO UUID ALEATORIO
        String codigo = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        
        return codigo;
    }
}
