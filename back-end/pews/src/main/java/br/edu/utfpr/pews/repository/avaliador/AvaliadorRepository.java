package br.edu.utfpr.pews.repository.avaliador;

import br.edu.utfpr.pews.model.avaliador.Avaliador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliadorRepository extends JpaRepository<Avaliador, String> {
    Optional<Avaliador> findByCertificado(String certificado);
}
