package com.victor.medagenda.dto;

import jakarta.validation.constraints.*;

public record MedicoDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "CRM é obrigatório")
        String crm,

        @NotBlank(message = "Especialidade é obrigatória")
        String especialidade,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "Endereço é obrigatório")
        String endereco

) {}
