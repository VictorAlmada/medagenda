package com.victor.medagenda.controller;

import com.victor.medagenda.dto.MedicoDTO;
import com.victor.medagenda.model.Medico;
import com.victor.medagenda.service.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> getAll() {
        return ResponseEntity.ok(medicoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> create(@RequestBody @Valid MedicoDTO dto) {
        MedicoDTO created = medicoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> update(@PathVariable Long id, @RequestBody @Valid MedicoDTO dto) {
        MedicoDTO updated = medicoService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
