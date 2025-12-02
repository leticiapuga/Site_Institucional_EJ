package com.include.inovale.landingpage.contollers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Importando os arquivos que você já tem (Confirmados pelo seu comando find)
import com.include.inovale.landingpage.models.entities.ContatoEntity;
import com.include.inovale.landingpage.services.ContatoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ContatoController {

    private final ContatoService service;

    // PÚBLICO: Enviar mensagem
    @PostMapping
    public ResponseEntity<ContatoEntity> enviar(@RequestBody ContatoEntity contato) {
        return ResponseEntity.ok(service.salvarMensagem(contato));
    }

    // ADMIN: Listar
    @GetMapping
    public ResponseEntity<List<ContatoEntity>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    // ADMIN: Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // ADMIN: Marcar como lido
    @PatchMapping("/{id}/lido")
    public ResponseEntity<ContatoEntity> marcarLido(@PathVariable UUID id) {
        return ResponseEntity.ok(service.marcarComoLido(id));
    }
}