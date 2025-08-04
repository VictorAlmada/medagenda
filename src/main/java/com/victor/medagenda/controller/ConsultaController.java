package com.victor.medagenda.controller;

import com.victor.medagenda.dto.ConsultaRequestDTO;
import com.victor.medagenda.dto.ConsultaResponseDTO;
import com.victor.medagenda.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

//    @GetMapping
//    public ResponseEntity<List<ConsultaResponseDTO>> getAll() {
//        return ResponseEntity.ok(consultaService.getAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> create(@RequestBody @Valid ConsultaRequestDTO dto) {
        ConsultaResponseDTO saved = consultaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDTO dto) {
        ConsultaResponseDTO updated = consultaService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ConsultaResponseDTO>> listarConsultas(Pageable pageable) {
        Page<ConsultaResponseDTO> consultas = consultaService.listarConsultas(pageable);
        return ResponseEntity.ok(consultas);
    }

}
