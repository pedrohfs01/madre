package br.com.basis.madre.pacientes.repository;

import br.com.basis.madre.pacientes.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Spring Data JPA repository for the Paciente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findOneByCpf(String cpf);
    Optional<Paciente> findOneByRg(String rg);
    Optional<Paciente> findOneByNomePacienteIgnoreCaseAndNomeSocialIgnoreCase(String nomePaciente, String nomeSocial);
    Optional<Paciente> findOneByCartaoSus(String cartaoSus);
    Optional<Paciente> findOneByEmailPrincipalIgnoreCase(String emailPrincipal);

    Optional<Paciente> findOneByProntuario(String prontuario);

    @Query(value = "SELECT COUNT(nome_paciente) FROM Paciente ")
    int indexPacientes();
}