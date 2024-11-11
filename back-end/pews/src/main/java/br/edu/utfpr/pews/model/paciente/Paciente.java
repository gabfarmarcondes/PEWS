package br.edu.utfpr.pews.model.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Paciente {

    @Id
    private Long id;
    private String nome;
    private Integer anoNascimento;

    private String diagnostico;
    private String leito;

    private LocalDateTime  DIHentrada;
    private LocalDateTime DIHalta;
}
