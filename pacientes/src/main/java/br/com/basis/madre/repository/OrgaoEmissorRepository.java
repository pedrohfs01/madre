package br.com.basis.madre.repository;

import br.com.basis.madre.domain.OrgaoEmissor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the OrgaoEmissor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrgaoEmissorRepository extends JpaRepository<OrgaoEmissor, Long> {
}