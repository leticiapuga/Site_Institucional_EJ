package com.include.inovale.landingpage.contollers;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.include.inovale.landingpage.models.dtos.ReqCasosSucessoDTO;
import com.include.inovale.landingpage.models.dtos.ResCasosSucessoDTO;
import com.include.inovale.landingpage.services.CasosSucessoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cases")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CasosSucessoController {
    private final CasosSucessoService service;

    @PostMapping
    public ResponseEntity<ResCasosSucessoDTO> criar(@RequestBody @Validated ReqCasosSucessoDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResCasosSucessoDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResCasosSucessoDTO> buscar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResCasosSucessoDTO> atualizar(@PathVariable UUID id, @RequestBody @Validated ReqCasosSucessoDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}