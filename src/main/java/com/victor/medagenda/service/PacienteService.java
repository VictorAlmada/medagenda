package com.victor.medagenda.service;

import com.victor.medagenda.dto.PacienteDTO;
import com.victor.medagenda.exception.RecursoNaoEncontradoException;
import com.victor.medagenda.mapper.PacienteMapper;
import com.victor.medagenda.model.Paciente;
import com.victor.medagenda.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public List<PacienteDTO> getAll() {
        return pacienteRepository.findAll()
                .stream().map(pacienteMapper::toDto).toList();
    }

    public PacienteDTO getById(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente com ID: " + id + " não encontrado"));
        return pacienteMapper.toDto(paciente);
    }

    public PacienteDTO create(PacienteDTO dto) {
        Paciente novoPaciente = pacienteMapper.toEntity(dto);
        Paciente saved = pacienteRepository.save(novoPaciente);
        return pacienteMapper.toDto(saved);
    }

    public PacienteDTO update(Long id, PacienteDTO dto) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente com ID: " + id + " não encontrado"));

        pacienteExistente.setNome(dto.nome());
        pacienteExistente.setCpf(dto.cpf());
        pacienteExistente.setEmail(dto.email());
        pacienteExistente.setTelefone(dto.telefone());
        pacienteExistente.setEndereco(dto.endereco());
        pacienteExistente.setDataNascimento(dto.dataNascimento());

        Paciente atualizado = pacienteRepository.save(pacienteExistente);

        return pacienteMapper.toDto(atualizado);
    }

    public void delete(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Paciente com ID: " + id + " não encontrado");
        }
        pacienteRepository.deleteById(id);
    }
}
