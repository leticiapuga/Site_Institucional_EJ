package com.include.inovale.landingpage.services;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.entities.UsuarioEntity;
import com.include.inovale.landingpage.models.enums.PapelEnum;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioAutenticadoService{
    

    public UsuarioEntity usuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        try {
            UsuarioEntity usuario = (UsuarioEntity) authentication.getPrincipal();
            return usuario;
        } catch (Exception e) {
            throw new RuntimeException("Usuário não encontrado \n" + e);
        }
    }


    public UsuarioEntity verificaPapelAdmin(){
        UsuarioEntity user = usuarioLogado();
        if (user.getPerfil() != PapelEnum.ADMINISTRADOR) 
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "O usuário deve ter perfil de administrador para usuar essa funcionalidade"
            );
        return user;
    }
    
}