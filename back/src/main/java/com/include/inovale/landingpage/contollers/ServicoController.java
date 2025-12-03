package com.include.inovale.landingpage.contollers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.include.inovale.landingpage.models.dtos.ReqServicoDTO;
import com.include.inovale.landingpage.models.dtos.ResServicoDTO;
import com.include.inovale.landingpage.services.ServicoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/servico")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServicoController {
    private final ServicoService servicoService;
    
    @PostMapping
    public ResponseEntity<ResServicoDTO> criarServico(@RequestBody @Validated ReqServicoDTO dto){
        return ResponseEntity.ok().body(servicoService.criarServico(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResServicoDTO> buscarServico(@PathVariable UUID id){
        return ResponseEntity.ok().body(servicoService.buscarServico(id));
    }

    @GetMapping()
    public ResponseEntity<List<ResServicoDTO>> listarServicos(){
        return ResponseEntity.ok().body(servicoService.listarServicos());
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ResServicoDTO> atualizar(@PathVariable UUID id, @RequestBody @Validated ReqServicoDTO dto){
        return ResponseEntity.ok().body(servicoService.editarServico(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        servicoService.apagarServico(id);

        return ResponseEntity.noContent().build();
    }

}
