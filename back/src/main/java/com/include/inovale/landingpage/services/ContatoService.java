package com.include.inovale.landingpage.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID; 

import org.springframework.stereotype.Service;

import com.include.inovale.landingpage.models.dtos.ReqContatoDTO;
import com.include.inovale.landingpage.models.entities.ContatoEntity;
import com.include.inovale.landingpage.models.mappers.ContatoMapper;
import com.include.inovale.landingpage.models.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository repository;
    private final ContatoMapper contatoMapper;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    // metodo de salvamentento nao mudou.
    public ContatoEntity salvarMensagem(ReqContatoDTO dto) {
        ContatoEntity contato = contatoMapper.toEntity(dto);
        contato.setDataEnvio(LocalDateTime.now());
        contato.setLido(false);
        return repository.save(contato);
    }

    public List<ContatoEntity> listarTodas() {
        usuarioAutenticadoService.verificaPapelAdmin();
        return repository.findAll();
    }

    // MUDANÇA AQUI: Recebe UUID em vez de Long
    public void deletar(UUID id) {
        usuarioAutenticadoService.verificaPapelAdmin();

        repository.deleteById(id); 
    }

    public ContatoEntity marcarComoLido(UUID id) { 
        usuarioAutenticadoService.verificaPapelAdmin();

        ContatoEntity contato = repository.getReferenceById(id);
        if (contato.isLido() == true) return contato;

        contato.setLido(true);
        repository.save(contato);

        return contato;
    }

    public void apagar(UUID id) { 
        usuarioAutenticadoService.verificaPapelAdmin();
        
        repository.deleteById(id);
    }
}