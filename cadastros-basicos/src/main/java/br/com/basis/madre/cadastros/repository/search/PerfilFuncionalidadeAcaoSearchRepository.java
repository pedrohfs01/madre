package br.com.basis.madre.cadastros.repository.search;

import br.com.basis.madre.cadastros.domain.PerfilFuncionalidadeAcao;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the PerfilFuncionalidadeAcao entity.
 */
public interface PerfilFuncionalidadeAcaoSearchRepository extends ElasticsearchRepository<PerfilFuncionalidadeAcao, Long> {
}