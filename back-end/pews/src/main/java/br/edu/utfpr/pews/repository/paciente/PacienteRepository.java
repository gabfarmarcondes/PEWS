package br.edu.utfpr.pews.repository.paciente;

import br.edu.utfpr.pews.model.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente>findById(Long id);
}
