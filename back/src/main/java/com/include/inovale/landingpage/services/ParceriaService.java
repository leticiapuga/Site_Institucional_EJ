package com.include.inovale.landingpage.services;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.include.inovale.landingpage.models.dtos.ReqParceriaDTO;
import com.include.inovale.landingpage.models.dtos.ResParceriaDTO;
import com.include.inovale.landingpage.models.entities.ParceriaEntity;
import com.include.inovale.landingpage.models.mappers.ParceriaMapper;
import com.include.inovale.landingpage.models.repositories.ParceriaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParceriaService {
    private final ParceriaRepository repository;
    private final ParceriaMapper mapper;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    // CRIAR (Admin)
    public ResParceriaDTO criar(ReqParceriaDTO dto) {
        usuarioAutenticadoService.verificaPapelAdmin();
        ParceriaEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toResDTO(entity);
    }

    // LISTAR (Público)
    public List<ResParceriaDTO> listarTodas() {
        return mapper.toListResDTO(repository.findAll());
    }

    // BUSCAR UM (Público)
    public ResParceriaDTO buscarPorId(UUID id) {
        ParceriaEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parceria não encontrada"));
        return mapper.toResDTO(entity);
    }

    // EDITAR (Admin)
    public ResParceriaDTO atualizar(UUID id, ReqParceriaDTO dto) {
        usuarioAutenticadoService.verificaPapelAdmin();
        ParceriaEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parceria não encontrada"));
        
        entity = mapper.atualizarEntity(entity, dto);
        repository.save(entity);
        return mapper.toResDTO(entity);
    }

    // DELETAR (Admin)
    public void deletar(UUID id) {
        usuarioAutenticadoService.verificaPapelAdmin();
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parceria não encontrada");
        }
        repository.deleteById(id);
    }
}