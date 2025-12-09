package com.include.inovale.landingpage.contollers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.include.inovale.landingpage.models.dtos.ReqRecuperarSenhaDTO;
import com.include.inovale.landingpage.models.dtos.ResRecuperarSenhaDTO;
import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.services.RecuperacaoSenhaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recuperarSenha")
public class RecuperacaoController {
    private final RecuperacaoSenhaService recuperacaoSenhaService;
    
    @PostMapping("/gerarCodigo")
    public ResponseEntity<ResRecuperarSenhaDTO> gerarCodigoRecuperacao(@RequestBody @Validated ResRecuperarSenhaDTO dto){
        ResRecuperarSenhaDTO resposta = recuperacaoSenhaService.criarCogigoRecuperacao(dto);
        return ResponseEntity.ok().body(resposta);
    }

    @PatchMapping("/atualizar/{codigoRecuperacao}")
    public ResponseEntity<ResRegistrarUsuarioDTO> atualizarSenha(@RequestBody @Validated ReqRecuperarSenhaDTO dto){
        ResRegistrarUsuarioDTO resposta = recuperacaoSenhaService.mudarSenha(dto);
        return ResponseEntity.ok().body(resposta);
    }
}
