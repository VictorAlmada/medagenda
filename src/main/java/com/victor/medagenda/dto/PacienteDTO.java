package com.victor.medagenda.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PacienteDTO(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
        String cpf,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "Endereço é obrigatório")
        String endereco,

        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "Data de nascimento deve estar no passado")
        LocalDate dataNascimento

) {}
