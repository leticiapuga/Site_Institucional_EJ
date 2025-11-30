package com.include.inovale.landingpage.models.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.include.inovale.landingpage.models.dtos.ReqQuemSomosDTO;
import com.include.inovale.landingpage.models.dtos.ResQuemSomosDTO;
import com.include.inovale.landingpage.models.entities.QuemSomosEntity;

@Component
public class QuemSomosMapper {
    public QuemSomosEntity toEntity(ReqQuemSomosDTO dto){
        QuemSomosEntity quemSomos = new QuemSomosEntity();

        quemSomos.setNome(dto.getNome());
        quemSomos.setCargo(dto.getCargo());
        quemSomos.setFotoUrl(dto.getFotoUrl());
        quemSomos.setGithubUrl(dto.getGithubUrl());
        quemSomos.setLinkedinUrl(dto.getLinkedinUrl());

        return quemSomos;    
    }

    public ResQuemSomosDTO toResDTO(QuemSomosEntity membro){
        ResQuemSomosDTO dto = new ResQuemSomosDTO();
    
        dto.setId(membro.getId());
        dto.setNome(membro.getNome());
        dto.setCargo(membro.getCargo());
        dto.setFotoUrl(membro.getFotoUrl());
        dto.setGithubUrl(membro.getGithubUrl());
        dto.setLinkedinUrl(membro.getLinkedinUrl());

        return dto;
    }

    public List<ResQuemSomosDTO> toListResDTO(List<QuemSomosEntity> membros){
        // ENCERRANDO O MÉTODO SE O ARRAY MEMBROS ESTIVER VAZIO
        if (membros == null) return null;

        List<ResQuemSomosDTO> membros_dto = new ArrayList<>();
        for (QuemSomosEntity membro : membros) {
            membros_dto.add(this.toResDTO(membro));
        }

        return membros_dto;
    }

    public QuemSomosEntity atualizarQuemSomosEntity(QuemSomosEntity quemSomos, ResQuemSomosDTO dto){

        if (dto.getNome()!= null) quemSomos.setNome(dto.getNome());
        if (dto.getCargo()!= null) quemSomos.setCargo(dto.getCargo());
        if (dto.getFotoUrl()!= null) quemSomos.setFotoUrl(dto.getFotoUrl());
        if (dto.getGithubUrl()!= null) quemSomos.setGithubUrl(dto.getGithubUrl());
        if (dto.getLinkedinUrl()!= null) quemSomos.setLinkedinUrl(dto.getLinkedinUrl());

        return quemSomos;    
    }
}
