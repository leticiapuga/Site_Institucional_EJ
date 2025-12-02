package com.include.inovale.landingpage.contollers;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.include.inovale.landingpage.models.dtos.ReqParceriaDTO;
import com.include.inovale.landingpage.models.dtos.ResParceriaDTO;
import com.include.inovale.landingpage.services.ParceriaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parceria")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ParceriaController {

    private final ParceriaService service;

    @PostMapping
    public ResponseEntity<ResParceriaDTO> criar(@RequestBody @Validated ReqParceriaDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResParceriaDTO>> listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResParceriaDTO> buscar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResParceriaDTO> atualizar(@PathVariable UUID id, @RequestBody @Validated ReqParceriaDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}