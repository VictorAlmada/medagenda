package com.victor.medagenda.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequestDTO(

        @NotNull(message = "ID do médico é obrigatório")
        Long medicoId,

        @NotNull(message = "ID do paciente é obrigatório")
        Long pacienteId,

        @NotNull(message = "Data e hora da consulta são obrigatórias")
        @Future(message = "A data da consulta deve estar no futuro")
        LocalDateTime dataHora
) {}
