package com.include.inovale.landingpage.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.include.inovale.landingpage.models.entities.ContatoEntity;
import com.include.inovale.landingpage.models.repositories.ContatoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository repository;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    //  ENVIAR MENSAGEM (Público)
    public ContatoEntity salvarMensagem(ContatoEntity contato) {
        contato.setDataEnvio(LocalDateTime.now());
        contato.setLido(false);
        return repository.save(contato);
    }

    // LISTAR TODAS (Admin)
    public List<ContatoEntity> listarTodas() {
        usuarioAutenticadoService.verificaPapelAdmin();
        return repository.findAll();
    }

    // 3. DELETAR (Admin)
    public void deletar(UUID id) {
        usuarioAutenticadoService.verificaPapelAdmin();
        
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada");
        }
        repository.deleteById(id);
    }

    //  MARCAR COMO LIDO (Admin) 
    public ContatoEntity marcarComoLido(UUID id) {
        // Validação de segurança
        usuarioAutenticadoService.verificaPapelAdmin();

        // Busca a mensagem ou dá erro se não achar
        ContatoEntity contato = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada"));
        
        // Atualiza e salva
        contato.setLido(true);
        return repository.save(contato);
    }
}