package com.include.inovale.landingpage.contollers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.include.inovale.landingpage.models.dtos.ReqContatoDTO;
import com.include.inovale.landingpage.models.entities.ContatoEntity;
import com.include.inovale.landingpage.services.ContatoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;
    
    @PostMapping()
    public ResponseEntity<ContatoEntity> criarMensagem(@RequestBody @Validated ReqContatoDTO dto){
        ContatoEntity contato = contatoService.salvarMensagem(dto);
        return ResponseEntity.ok().body(contato);
    }

    @GetMapping()
    public ResponseEntity<List<ContatoEntity>> listarMensagens(){
        List<ContatoEntity> contatos = contatoService.listarTodas();
        return ResponseEntity.ok().body(contatos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ContatoEntity> marcarLido(@PathVariable UUID id){
        ContatoEntity contato = contatoService.marcarComoLido(id);
        return ResponseEntity.ok().body(contato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable UUID id){
        contatoService.apagar(id);
        return ResponseEntity.noContent().build();
    }
}
