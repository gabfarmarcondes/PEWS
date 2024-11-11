package br.edu.utfpr.pews.dto;

import java.time.LocalDateTime;

public record PacienteDTO(
        String nome,
        Integer anoNascimento,
        String diagnostico,
        String leito,
        LocalDateTime DIHentrada,
        LocalDateTime DIHalta
) { }
