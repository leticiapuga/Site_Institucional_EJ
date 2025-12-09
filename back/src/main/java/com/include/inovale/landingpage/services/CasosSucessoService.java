package com.include.inovale.landingpage.services;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.include.inovale.landingpage.models.dtos.ReqCasosSucessoDTO;
import com.include.inovale.landingpage.models.dtos.ResCasosSucessoDTO;
import com.include.inovale.landingpage.models.entities.CasosSucesoEntity;
import com.include.inovale.landingpage.models.entities.ServicoEntity;
import com.include.inovale.landingpage.models.mappers.CasosSucessoMapper;
import com.include.inovale.landingpage.models.repositories.CasosSucesoRepository;
import com.include.inovale.landingpage.models.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CasosSucessoService {
    private final CasosSucesoRepository repository;
    private final ServicoRepository servicoRepository;
    private final CasosSucessoMapper mapper;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    public ResCasosSucessoDTO criar(ReqCasosSucessoDTO dto) {
        usuarioAutenticadoService.verificaPapelAdmin();
        CasosSucesoEntity entity = mapper.toEntity(dto);
        if (dto.getIdServico() != null) {
            ServicoEntity servico = servicoRepository.findById(dto.getIdServico())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
            entity.setServico(servico);
        }
        repository.save(entity);
        return mapper.toResDTO(entity);
    }

    public List<ResCasosSucessoDTO> listarTodos() {
        return mapper.toListResDTO(repository.findAll());
    }

    public ResCasosSucessoDTO buscarPorId(UUID id) {
        CasosSucesoEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case não encontrado"));
        return mapper.toResDTO(entity);
    }

    public ResCasosSucessoDTO atualizar(UUID id, ReqCasosSucessoDTO dto) {
        usuarioAutenticadoService.verificaPapelAdmin();
        CasosSucesoEntity entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Case não encontrado"));
        entity = mapper.atualizarEntity(entity, dto);
        if (dto.getIdServico() != null) {
            ServicoEntity servico = servicoRepository.findById(dto.getIdServico())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
            entity.setServico(servico);
        }
        repository.save(entity);
        return mapper.toResDTO(entity);
    }

    public void deletar(UUID id) {
        usuarioAutenticadoService.verificaPapelAdmin();
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Case não encontrado");
        }
        repository.deleteById(id);
    }
}