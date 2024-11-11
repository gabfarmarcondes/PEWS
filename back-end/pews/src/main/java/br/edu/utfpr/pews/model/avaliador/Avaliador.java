package br.edu.utfpr.pews.model.avaliador;

import br.edu.utfpr.pews.dto.AvaliadorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Avaliador {
    @Id
    private String certificado;
    private String nome;
    private String funcao;

    public Avaliador(AvaliadorDTO avaliadorDTO) {
        this.certificado = avaliadorDTO.certificado();
        this.nome = avaliadorDTO.nome();
        this.funcao = avaliadorDTO.funcao();
    }
}
