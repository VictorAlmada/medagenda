package com.victor.medagenda.service;

import com.victor.medagenda.dto.MedicoDTO;
import com.victor.medagenda.exception.RecursoNaoEncontradoException;
import com.victor.medagenda.mapper.MedicoMapper;
import com.victor.medagenda.model.Medico;
import com.victor.medagenda.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public List<MedicoDTO> getAll() {
        return medicoMapper.toDtoList(medicoRepository.findAll());
    }

    public MedicoDTO getById(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico com ID: " + id + " não encontrado."));
        return medicoMapper.toDTO(medico);
    }

    public MedicoDTO create(MedicoDTO dto) {
        if (medicoRepository.existsByCrm(dto.crm())) {
            throw new IllegalArgumentException("CRM já cadastrado");
        }

        Medico medico = medicoMapper.toEntity(dto);
        return medicoMapper.toDTO(medicoRepository.save(medico));
    }

    public MedicoDTO update(Long id, MedicoDTO dto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico com ID: " + id + " não encontrado."));

        medico.setNome(dto.nome());
        medico.setEmail(dto.email());
        medico.setCrm(dto.crm());
        medico.setEspecialidade(dto.especialidade());
        medico.setTelefone(dto.telefone());
        medico.setEndereco(dto.endereco());

        return medicoMapper.toDTO(medicoRepository.save(medico));
    }

    public void delete(Long id) {
        if (!medicoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Médico com ID: " + id + " não encontrado.");
        }
        medicoRepository.deleteById(id);
    }
}
