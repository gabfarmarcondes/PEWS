package br.edu.utfpr.pews.model.avaliador;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Avaliador {
    @Id
    private String certificado;
    private String nome;
    private String funcao;
}
