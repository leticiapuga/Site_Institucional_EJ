package com.include.inovale.landingpage.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.include.inovale.landingpage.models.dtos.ReqServicoDTO;
import com.include.inovale.landingpage.models.dtos.ResServicoDTO;
import com.include.inovale.landingpage.models.entities.ServicoEntity;
import com.include.inovale.landingpage.models.mappers.ServicoMapper;
import com.include.inovale.landingpage.models.repositories.ServicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;
    private final ServicoMapper servicoMapper;
    private final UsuarioAutenticadoService usuarioAutenticadoService;

    // CRIAR (Admin)
    public ResServicoDTO criarServico(ReqServicoDTO dto){
        usuarioAutenticadoService.verificaPapelAdmin();

        ServicoEntity servico = servicoRepository.save(servicoMapper.toEntity(dto));

        return servicoMapper.toResDTO(servico);
    }

    // BUSCAR UM (Público)
    public ResServicoDTO buscarServico(UUID id){
        return servicoMapper.toResDTO(servicoRepository.getReferenceById(id));
    }

    // LISTAR (Público)
    public List<ResServicoDTO> listarServicos(){
        return servicoMapper.toListResDTO(servicoRepository.findAll());
    }


}
