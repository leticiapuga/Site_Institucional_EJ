package com.include.inovale.landingpage.models.mappers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.include.inovale.landingpage.models.dtos.ReqCasosSucessoDTO;
import com.include.inovale.landingpage.models.dtos.ResCasosSucessoDTO;
import com.include.inovale.landingpage.models.entities.CasosSucesoEntity;

@Component
public class CasosSucessoMapper {

    public CasosSucesoEntity toEntity(ReqCasosSucessoDTO dto) {
        CasosSucesoEntity entity = new CasosSucesoEntity();
        
        // AGORA VAI FUNCIONAR POIS O DTO TEM ESSE CAMPO
        entity.setNomeProjeto(dto.getNomeProjeto());
        
        entity.setCliente(dto.getCliente());
        entity.setDescricaoSolucao(dto.getDescricaoSolucao());
        entity.setDepoimentoCliente(dto.getDepoimentoCliente());
        entity.setImagemUrl(dto.getImagemUrl());
        return entity;
    }

    public ResCasosSucessoDTO toResDTO(CasosSucesoEntity entity) {
        ResCasosSucessoDTO dto = new ResCasosSucessoDTO();
        dto.setId(entity.getId());
        
        // AGORA VAI FUNCIONAR POIS O RES-DTO TEM ESSE CAMPO
        dto.setNomeProjeto(entity.getNomeProjeto());
        
        dto.setCliente(entity.getCliente());
        dto.setDescricaoSolucao(entity.getDescricaoSolucao());
        dto.setDepoimentoCliente(entity.getDepoimentoCliente());
        dto.setImagemUrl(entity.getImagemUrl());
        
        if(entity.getServico() != null) {
            dto.setNomeServico(entity.getServico().getTitulo());
        }
        
        return dto;
    }

    public List<ResCasosSucessoDTO> toListResDTO(List<CasosSucesoEntity> lista) {
        List<ResCasosSucessoDTO> dtos = new ArrayList<>();
        if (lista != null) {
            for (CasosSucesoEntity entity : lista) {
                dtos.add(toResDTO(entity));
            }
        }
        return dtos;
    }

    public CasosSucesoEntity atualizarEntity(CasosSucesoEntity entity, ReqCasosSucessoDTO dto) {
        if (dto.getNomeProjeto() != null) entity.setNomeProjeto(dto.getNomeProjeto());
        
        if (dto.getCliente() != null) entity.setCliente(dto.getCliente());
        if (dto.getDescricaoSolucao() != null) entity.setDescricaoSolucao(dto.getDescricaoSolucao());
        if (dto.getDepoimentoCliente() != null) entity.setDepoimentoCliente(dto.getDepoimentoCliente());
        if (dto.getImagemUrl() != null) entity.setImagemUrl(dto.getImagemUrl());
        return entity;
    }
}