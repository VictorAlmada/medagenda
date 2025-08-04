package com.victor.medagenda.repository;

import com.victor.medagenda.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // boolean existsByMedicoAndDataHora(Long medicoId, LocalDateTime dataHora);

}
