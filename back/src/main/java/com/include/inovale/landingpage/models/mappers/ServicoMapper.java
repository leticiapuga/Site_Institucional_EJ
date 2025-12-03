package com.include.inovale.landingpage.models.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.include.inovale.landingpage.models.dtos.ReqServicoDTO;
import com.include.inovale.landingpage.models.dtos.ResServicoDTO;
import com.include.inovale.landingpage.models.entities.ServicoEntity;

@Component
public class ServicoMapper {
    public ServicoEntity toEntity(ReqServicoDTO dto){
        ServicoEntity servicoEntity = new ServicoEntity();

        servicoEntity.setTitulo(dto.getTitulo());
        servicoEntity.setDescricao(dto.getDescricao());
        servicoEntity.setImagemUrl(dto.getImagemUrl());

        return servicoEntity;
    }

    public ResServicoDTO toResDTO(ServicoEntity servico){
        ResServicoDTO dto = new ResServicoDTO();

        dto.setId(servico.getId());
        dto.setTitulo(servico.getTitulo());
        dto.setDescricao(servico.getDescricao());
        dto.setImagemUrl(servico.getImagemUrl());

        return dto;
    }

    public List<ResServicoDTO> toListResDTO(List<ServicoEntity> servicos){
        if(servicos == null ) return null;

        List<ResServicoDTO> servicosDTO = new ArrayList<>();
        for (ServicoEntity servico : servicos) {
            servicosDTO.add(this.toResDTO(servico));
        }

        return servicosDTO;
    }

    public ServicoEntity atualizarEntity(ServicoEntity servicoEntity, ReqServicoDTO dto){
        

        if(dto.getTitulo() != null) servicoEntity.setTitulo(dto.getTitulo());
        if(dto.getDescricao() != null) servicoEntity.setDescricao(dto.getDescricao());
        if(dto.getImagemUrl() != null) servicoEntity.setImagemUrl(dto.getImagemUrl());

        return servicoEntity;
    }
}
