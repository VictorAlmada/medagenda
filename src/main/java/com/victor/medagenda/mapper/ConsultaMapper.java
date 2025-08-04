package com.victor.medagenda.mapper;

import com.victor.medagenda.dto.ConsultaRequestDTO;
import com.victor.medagenda.dto.ConsultaResponseDTO;
import com.victor.medagenda.model.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(source = "medico.nome", target = "nomeMedico")
    @Mapping(source = "paciente.nome", target = "nomePaciente")
    ConsultaResponseDTO toDTO(Consulta consulta);

    List<ConsultaResponseDTO> toDTOList(List<Consulta> consultas);

    // Para criar Consulta a partir do DTO de entrada
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "AGENDADA")
    @Mapping(target = "motivoCancelamento", ignore = true)
    @Mapping(target = "medico", ignore = true)
    @Mapping(target = "paciente", ignore = true)
    Consulta toEntity(ConsultaRequestDTO dto);
}
