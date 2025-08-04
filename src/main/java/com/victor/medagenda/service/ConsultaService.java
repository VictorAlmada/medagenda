package com.victor.medagenda.service;

import com.victor.medagenda.dto.ConsultaRequestDTO;
import com.victor.medagenda.dto.ConsultaResponseDTO;
import com.victor.medagenda.exception.RecursoNaoEncontradoException;
import com.victor.medagenda.mapper.ConsultaMapper;
import com.victor.medagenda.model.Consulta;
import com.victor.medagenda.model.Medico;
import com.victor.medagenda.model.Paciente;
import com.victor.medagenda.repository.ConsultaRepository;
import com.victor.medagenda.repository.MedicoRepository;
import com.victor.medagenda.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final ConsultaMapper consultaMapper;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public List<ConsultaResponseDTO> getAll() {
        return consultaMapper.toDTOList(consultaRepository.findAll());
    }

    public ConsultaResponseDTO getById(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Consulta não encontrada"));
        return consultaMapper.toDTO(consulta);
    }

    public ConsultaResponseDTO create(ConsultaRequestDTO dto) {
        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado"));

        Consulta consulta = consultaMapper.toEntity(dto);
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);

        consultaRepository.save(consulta);

        return consultaMapper.toDTO(consulta);
    }

    public ConsultaResponseDTO update(Long id, ConsultaRequestDTO dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Consulta não encontrada"));

        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado"));

        consulta.setDataHora(dto.dataHora());
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consultaRepository.save(consulta);
        return consultaMapper.toDTO(consulta);
    }

    public void delete(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Consulta não encontrada");
        }
        consultaRepository.deleteById(id);
    }

    // LISTAR CONSULTAS PAGINADA
    public Page<ConsultaResponseDTO> listarConsultas(Pageable pageable) {
        return consultaRepository.findAll(pageable).map(consultaMapper::toDTO);
    }

}
