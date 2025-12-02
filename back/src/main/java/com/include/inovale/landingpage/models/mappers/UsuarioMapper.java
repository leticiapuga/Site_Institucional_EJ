package com.include.inovale.landingpage.models.mappers;


import org.springframework.stereotype.Component;

import com.include.inovale.landingpage.models.dtos.ReqRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.entities.UsuarioEntity;

@Component
public class UsuarioMapper {

    public UsuarioEntity reqRegistrarUsuarioDTOToEntity(ReqRegistrarUsuarioDTO dto){
        // INSTANCIANDO O USUÁRIO QUE SERÁ RETORNADO
        UsuarioEntity usuario = new UsuarioEntity();
        
        // PREENCHENDO OS CAMPOS DO OBJETO
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        return usuario;
    }

    public ResRegistrarUsuarioDTO entityToResRegistrarUsuarioDTO (UsuarioEntity usuarioEntity){
        // INSTANCIANDO O DTO QUE SERÁ RETORNADO
        ResRegistrarUsuarioDTO usuarioDTO = new ResRegistrarUsuarioDTO();
        
        // PREENCHENDO OS CAMPOS DO OBJETO
        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setNome(usuarioEntity.getNome());
        usuarioDTO.setEmail(usuarioEntity.getEmail());

        return usuarioDTO;
    }
}
