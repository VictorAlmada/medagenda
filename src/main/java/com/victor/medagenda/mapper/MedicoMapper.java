package com.victor.medagenda.mapper;

import com.victor.medagenda.dto.MedicoDTO;
import com.victor.medagenda.model.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    Medico toEntity(MedicoDTO dto);

    MedicoDTO toDTO(Medico entity);

    List<MedicoDTO> toDtoList(List<Medico> entities);
}
