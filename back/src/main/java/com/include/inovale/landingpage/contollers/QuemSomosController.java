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

import com.include.inovale.landingpage.models.dtos.ReqQuemSomosDTO;
import com.include.inovale.landingpage.models.dtos.ResQuemSomosDTO;
import com.include.inovale.landingpage.services.QuemSomosService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/membro")
public class QuemSomosController {
    private final QuemSomosService quemSomosService;

    @PostMapping()
    public ResponseEntity<ResQuemSomosDTO> salvarMembro(@RequestBody @Validated ReqQuemSomosDTO dto){
        ResQuemSomosDTO membro = quemSomosService.criarMembro(dto);
        return ResponseEntity.ok().body(membro);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResQuemSomosDTO> deletarMembro(@PathVariable UUID id){
        ResQuemSomosDTO membro = quemSomosService.deletarMembro(id);
        return ResponseEntity.ok().body(membro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResQuemSomosDTO> buscarMembro(@PathVariable UUID id){
        ResQuemSomosDTO membro = quemSomosService.buscarMembro(id);
        return ResponseEntity.ok().body(membro);
    }

    @GetMapping()
    public ResponseEntity<List<ResQuemSomosDTO>> buscarTodosMembros(){
        List<ResQuemSomosDTO> membros = quemSomosService.buscarTodosMembros();
        return ResponseEntity.ok().body(membros);
    }

    @PatchMapping()
    public ResponseEntity<ResQuemSomosDTO> salvarMembro(@RequestBody @Validated ResQuemSomosDTO dto){
        ResQuemSomosDTO membro = quemSomosService.editarMembro(dto);
        return ResponseEntity.ok().body(membro);
    }
}
