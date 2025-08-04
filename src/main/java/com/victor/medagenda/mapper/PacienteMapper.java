package com.victor.medagenda.mapper;

import com.victor.medagenda.dto.PacienteDTO;
import com.victor.medagenda.model.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDTO toDto(Paciente entity);

    Paciente toEntity(PacienteDTO dto);
}
