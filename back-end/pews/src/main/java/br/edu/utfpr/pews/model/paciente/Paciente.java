package br.edu.utfpr.pews.model.paciente;

import br.edu.utfpr.pews.dto.PacienteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    private Long id;
    private String nome;
    private Integer anoNascimento;

    private String diagnostico;
    private String leito;

    private LocalDateTime  DIHentrada;
    private LocalDateTime DIHalta;
    private long DIHtotal;

    public long getDIHtotal(LocalDateTime DIHalta, LocalDateTime DIHentrada) {
        this.DIHalta = DIHalta;
        this.DIHentrada = DIHentrada;
        if (DIHalta != null && DIHentrada != null) {
            return this.DIHtotal = Duration.between(DIHalta, DIHentrada).toDays();
        }
        return 0;
    }

    public Paciente(PacienteDTO pacienteDTO){
        this.nome = pacienteDTO.nome();
        this.anoNascimento = pacienteDTO.anoNascimento();
        this.diagnostico = pacienteDTO.diagnostico();
        this.leito = pacienteDTO.leito();
        this.DIHentrada = pacienteDTO.DIHentrada();
        this.DIHalta = pacienteDTO.DIHalta();
        this.DIHtotal = getDIHtotal(this.DIHentrada, this.DIHalta);
    }
}
