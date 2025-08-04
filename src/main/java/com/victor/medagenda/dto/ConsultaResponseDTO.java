package com.victor.medagenda.dto;

import com.victor.medagenda.model.StatusConsulta;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
    Long id,
    String nomeMedico,
    String nomePaciente,
    LocalDateTime dataHora,
    StatusConsulta status,
    String motivoCancelamento)
{}

