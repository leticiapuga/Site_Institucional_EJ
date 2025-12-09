package com.include.inovale.landingpage.models.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.include.inovale.landingpage.models.dtos.ReqContatoDTO;
import com.include.inovale.landingpage.models.entities.ContatoEntity;

@Component
public class ContatoMapper {
    public ContatoEntity toEntity(ReqContatoDTO dto){
        ContatoEntity contato = new ContatoEntity();

        contato.setNome(dto.getNome());
        contato.setDataEnvio(LocalDateTime.now());
        contato.setEmail(dto.getEmail());
        contato.setTelefone(dto.getTelefone());
        contato.setMensagem(dto.getMensagem());
        contato.setLido(false);
        
        return contato;
    }
}
