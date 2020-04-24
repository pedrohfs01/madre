package br.com.basis.madre.repository;

import br.com.basis.madre.domain.Paciente;
import br.com.basis.madre.service.projection.PacienteResumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Paciente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<PacienteResumo> findAllProjectedPacienteResumoBy(Pageable pageable);
}