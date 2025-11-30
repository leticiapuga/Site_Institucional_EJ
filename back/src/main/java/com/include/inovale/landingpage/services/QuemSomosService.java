package com.include.inovale.landingpage.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.dtos.ReqQuemSomosDTO;
import com.include.inovale.landingpage.models.dtos.ResQuemSomosDTO;
import com.include.inovale.landingpage.models.entities.QuemSomosEntity;
import com.include.inovale.landingpage.models.mappers.QuemSomosMapper;
import com.include.inovale.landingpage.models.repositories.QuemSomosRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuemSomosService {
    private final QuemSomosRepository quemSomosRepository;
    private final QuemSomosMapper quemSomosMapper;

    public ResQuemSomosDTO criarMembro(ReqQuemSomosDTO dto){
        QuemSomosEntity membro = quemSomosMapper.toEntity(dto);
        quemSomosRepository.save(membro);

        return quemSomosMapper.toResDTO(membro);
    }

    public ResQuemSomosDTO deletarMembro(UUID id){
        QuemSomosEntity membro = quemSomosRepository.getReferenceById(id);
        if (membro == null) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Não há usuário registrado com esse id"
        );
        quemSomosRepository.delete(membro);

        return quemSomosMapper.toResDTO(membro);
    }

    public ResQuemSomosDTO buscarMembro(UUID id){
        QuemSomosEntity membro = quemSomosRepository.getReferenceById(id);
        if (membro == null) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Não há usuário registrado com esse id"
        );

        return quemSomosMapper.toResDTO(membro);
    }

    public List<ResQuemSomosDTO> buscarTodosMembros(){
        List<QuemSomosEntity> membros = quemSomosRepository.findAll();
        if (membros == null) throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "Não há membros registrados"
        );

        return quemSomosMapper.toListResDTO(membros);
    }

    public ResQuemSomosDTO editarMembro(ResQuemSomosDTO dto){
        QuemSomosEntity membro = quemSomosRepository.getReferenceById(dto.getId());
        membro = quemSomosMapper.atualizarQuemSomosEntity(membro, dto);
        quemSomosRepository.save(membro);

        return quemSomosMapper.toResDTO(membro);
    }
}
