package com.include.inovale.landingpage.contollers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.include.inovale.landingpage.models.dtos.ReqLogarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ReqRegistrarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ResLogarUsuarioDTO;
import com.include.inovale.landingpage.models.dtos.ResRegistrarUsuarioDTO;
import com.include.inovale.landingpage.services.AutenticacaoService;
import com.include.inovale.landingpage.services.UsuarioConfirmacaoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final UsuarioConfirmacaoService usuarioConfirmacaoService;
    private final AutenticacaoService autenticacaoService;

    @PostMapping("/registrar")
    public ResponseEntity<ResRegistrarUsuarioDTO> registrarUsuario(@RequestBody @Validated ReqRegistrarUsuarioDTO dto){
        ResRegistrarUsuarioDTO user = autenticacaoService.registrarUsuario(dto);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/validar/{codigo}")
    public ResponseEntity<ResRegistrarUsuarioDTO> validarUsuario(@PathVariable String codigo){
        ResRegistrarUsuarioDTO user = usuarioConfirmacaoService.confirmarUsuario(codigo);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/entrar")
    public ResponseEntity<ResLogarUsuarioDTO> logarUsuario(@RequestBody @Validated ReqLogarUsuarioDTO dto){
        ResLogarUsuarioDTO user = autenticacaoService.logarUsuario(dto);
        return ResponseEntity.ok().body(user);
    }
}
