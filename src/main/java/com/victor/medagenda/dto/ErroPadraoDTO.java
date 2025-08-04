package com.victor.medagenda.dto;

import java.time.Instant;
import java.util.List;

public record ErroPadraoDTO(
        Instant timestamp,
        int status,
        String error,
        String path,
        List<String> mensagens
) {}
