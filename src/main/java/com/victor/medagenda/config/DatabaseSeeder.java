package com.victor.medagenda.config;

import com.victor.medagenda.model.Medico;
import com.victor.medagenda.model.Paciente;
import com.victor.medagenda.repository.MedicoRepository;
import com.victor.medagenda.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void run(String... args) throws Exception {

        if (medicoRepository.count() == 0) {
            Medico m1 = Medico.builder()
                    .nome("Junior")
                    .email("junior@email.com")
                    .crm("122")
                    .especialidade("Geral")
                    .telefone("51991768065")
                    .endereco("Rua Figueira, 300")
                    .build();

            Medico m2 = Medico.builder()
                    .nome("Marcelo")
                    .email("marcelo@email.com")
                    .crm("333")
                    .especialidade("Geral")
                    .telefone("51997855293")
                    .endereco("Rua Oliveira, 129")
                    .build();

            medicoRepository.saveAll(List.of(m1, m2));
        }

        if (pacienteRepository.count() == 0) {

            Paciente p1 = Paciente.builder()
                    .nome("João")
                    .email("joao@email.com")
                    .cpf("02083037791")
                    .telefone("51991778025")
                    .endereco("Rua Universo, 777")
                    .dataNascimento(LocalDate.of(1990, 3, 3))
                    .build();

            Paciente p2 = Paciente.builder()
                    .nome("Paulo")
                    .email("paulo@email.com")
                    .cpf("02070080055")
                    .telefone("51994563021")
                    .endereco("Rua Marau, 153")
                    .dataNascimento(LocalDate.of(1985, 1, 1))
                    .build();

            pacienteRepository.saveAll(List.of(p1, p2));
        }
    }
}
