package com.include.inovale.landingpage.models.mappers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.include.inovale.landingpage.models.dtos.ReqParceriaDTO;
import com.include.inovale.landingpage.models.dtos.ResParceriaDTO;
import com.include.inovale.landingpage.models.entities.ParceriaEntity;

@Component
public class ParceriaMapper {

    public ParceriaEntity toEntity(ReqParceriaDTO dto) {
        ParceriaEntity entity = new ParceriaEntity();
        entity.setNomeEmpresa(dto.getNomeEmpresa());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setSiteUrl(dto.getSiteUrl());
        return entity;
    }

    public ResParceriaDTO toResDTO(ParceriaEntity entity) {
        ResParceriaDTO dto = new ResParceriaDTO();
        dto.setId(entity.getId());
        dto.setNomeEmpresa(entity.getNomeEmpresa());
        dto.setLogoUrl(entity.getLogoUrl());
        dto.setSiteUrl(entity.getSiteUrl());
        return dto;
    }

    public List<ResParceriaDTO> toListResDTO(List<ParceriaEntity> lista) {
        List<ResParceriaDTO> dtos = new ArrayList<>();
        if (lista != null) {
            for (ParceriaEntity entity : lista) {
                dtos.add(toResDTO(entity));
            }
        }
        return dtos;
    }

    public ParceriaEntity atualizarEntity(ParceriaEntity entity, ReqParceriaDTO dto) {
        if (dto.getNomeEmpresa() != null) entity.setNomeEmpresa(dto.getNomeEmpresa());
        if (dto.getLogoUrl() != null) entity.setLogoUrl(dto.getLogoUrl());
        if (dto.getSiteUrl() != null) entity.setSiteUrl(dto.getSiteUrl());
        return entity;
    }
}