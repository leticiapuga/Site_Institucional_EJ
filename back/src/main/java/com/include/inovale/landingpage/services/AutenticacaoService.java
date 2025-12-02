package com.include.inovale.landingpage.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.dtos.ReqLogarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ReqRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ResLogarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.entities.UsuarioEntity;
import com.include.inovale.landingpage.models.enums.PapelEnum;
import com.include.inovale.landingpage.models.enums.UsuarioEstadoEnum;
import com.include.inovale.landingpage.models.mappers.UsuarioMapper;
import com.include.inovale.landingpage.models.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AutenticacaoService {
    private final UsuarioConfirmacaoService usuarioConfirmacaoService;
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final TokenService tokenService;
    
    
    public ResRegistrarUsuarioDTO registrarUsuario(ReqRegistrarUsuarioDTO usuarioDTO){
        String senha;
        // CRIPTOGRAFAR A SENHA PARA GUARDAR NO BANCO DE DADOS
        senha = new BCryptPasswordEncoder().encode(usuarioDTO.getSenha());

        // ATUALIZANDO A SENHA PARA A VERSÃO CRIPTOGRAFADA
        usuarioDTO.setSenha(senha);

        
        
        // PROCURANDO POR UM REGISTRO DE USUÁRIO COM O E-MAIL INFORMADO
        UsuarioEntity usuario = (UsuarioEntity) usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if (usuario != null) {
            // PARANDO A EXECUÇÃO DO MÉTODO CASO O E-MAIL SEJA DE OUTRO USUÁRIO
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "O e-mail informado já está em uso!"
            );
        }
        
        // CRIANDO O OBJETO QUE SERÁ GUARDADA NO BANCO DE DADOS
        UsuarioEntity usuarioEntity;
        usuarioEntity = usuarioMapper.reqRegistrarUsuarioDTOToEntity(usuarioDTO);
        
        // DEFININDO O ESTADO PADRÃO DO USUÁRIO
        usuarioEntity.setEstadoUsuario(UsuarioEstadoEnum.PENDENTE);

        // DEFININDO O PAPEL PADRÃO DO USUÁRIO
        usuarioEntity.setPerfil(PapelEnum.USUARIO);

        // SALVANDO O OBJETO
        usuarioRepository.save(usuarioEntity);

        usuarioConfirmacaoService.confirmarCriacaoUsuario(usuarioEntity);
        
        // RETORNANDO O USUÁRIO CRIADO
        return usuarioMapper.entityToResRegistrarUsuarioDTO(usuarioEntity);
    }

    public ResLogarUsuarioDTO logarUsuario(ReqLogarUsuarioDTO usuarioDTO){
        UsuarioEntity usuario = (UsuarioEntity) usuarioRepository.findByEmail(usuarioDTO.getEmail());

        if (usuario == null) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Usuário inexistente!"
        );

        if (usuario.getEstadoUsuario() == UsuarioEstadoEnum.INATIVO) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "Usuário banido!"
        );

        if (usuario.getEstadoUsuario() != UsuarioEstadoEnum.ATIVO) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            "O usuário não possui registro ativo na plataforma!"
        );

        UsernamePasswordAuthenticationToken usernamePassword;
        usernamePassword = new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getSenha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.gerarToken((UsuarioEntity) auth.getPrincipal());
        
        ResLogarUsuarioDTO loginRes = new ResLogarUsuarioDTO();
        loginRes.setId(usuario.getId());
        loginRes.setEmail(usuario.getEmail());
        loginRes.setNome(usuario.getNome());
        loginRes.setToken(token);

        return loginRes;
    }
}
