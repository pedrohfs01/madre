package br.com.basis.madre.cadastros.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.basis.madre.cadastros.domain.Perfil_funcionalidade_acao;
import br.com.basis.madre.cadastros.service.Perfil_funcionalidade_acaoService;
import br.com.basis.madre.cadastros.web.rest.errors.BadRequestAlertException;
import br.com.basis.madre.cadastros.web.rest.util.HeaderUtil;
import br.com.basis.madre.cadastros.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing Perfil_funcionalidade_acao.
 */
@RestController
@RequestMapping("/api")
public class Perfil_funcionalidade_acaoResource {

    private final Logger log = LoggerFactory.getLogger(Perfil_funcionalidade_acaoResource.class);

    private static final String ENTITY_NAME = "perfil_funcionalidade_acao";

    private final Perfil_funcionalidade_acaoService perfil_funcionalidade_acaoService;

    public Perfil_funcionalidade_acaoResource(Perfil_funcionalidade_acaoService perfil_funcionalidade_acaoService) {
        this.perfil_funcionalidade_acaoService = perfil_funcionalidade_acaoService;
    }

    /**
     * POST  /perfil-funcionalidade-acaos : Create a new perfil_funcionalidade_acao.
     *
     * @param perfil_funcionalidade_acao the perfil_funcionalidade_acao to create
     * @return the ResponseEntity with status 201 (Created) and with body the new perfil_funcionalidade_acao, or with status 400 (Bad Request) if the perfil_funcionalidade_acao has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/perfil-funcionalidade-acaos")
    @Timed
    public ResponseEntity<Perfil_funcionalidade_acao> createPerfil_funcionalidade_acao(@Valid @RequestBody Perfil_funcionalidade_acao perfil_funcionalidade_acao) throws URISyntaxException {
        log.debug("REST request to save Perfil_funcionalidade_acao : {}", perfil_funcionalidade_acao);
        if (perfil_funcionalidade_acao.getId() != null) {
            throw new BadRequestAlertException("A new perfil_funcionalidade_acao cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Perfil_funcionalidade_acao result = perfil_funcionalidade_acaoService.save(perfil_funcionalidade_acao);
        return ResponseEntity.created(new URI("/api/perfil-funcionalidade-acaos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /perfil-funcionalidade-acaos : Updates an existing perfil_funcionalidade_acao.
     *
     * @param perfil_funcionalidade_acao the perfil_funcionalidade_acao to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated perfil_funcionalidade_acao,
     * or with status 400 (Bad Request) if the perfil_funcionalidade_acao is not valid,
     * or with status 500 (Internal Server Error) if the perfil_funcionalidade_acao couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/perfil-funcionalidade-acaos")
    @Timed
    public ResponseEntity<Perfil_funcionalidade_acao> updatePerfil_funcionalidade_acao(@Valid @RequestBody Perfil_funcionalidade_acao perfil_funcionalidade_acao) throws URISyntaxException {
        log.debug("REST request to update Perfil_funcionalidade_acao : {}", perfil_funcionalidade_acao);
        if (perfil_funcionalidade_acao.getId() == null) {
            return createPerfil_funcionalidade_acao(perfil_funcionalidade_acao);
        }
        Perfil_funcionalidade_acao result = perfil_funcionalidade_acaoService.save(perfil_funcionalidade_acao);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, perfil_funcionalidade_acao.getId().toString()))
            .body(result);
    }

    /**
     * GET  /perfil-funcionalidade-acaos : get all the perfil_funcionalidade_acaos.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of perfil_funcionalidade_acaos in body
     */
    @GetMapping("/perfil-funcionalidade-acaos")
    @Timed
    public ResponseEntity<List<Perfil_funcionalidade_acao>> getAllPerfil_funcionalidade_acaos(Pageable pageable) {
        log.debug("REST request to get a page of Perfil_funcionalidade_acaos");
        Page<Perfil_funcionalidade_acao> page = perfil_funcionalidade_acaoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/perfil-funcionalidade-acaos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /perfil-funcionalidade-acaos/:id : get the "id" perfil_funcionalidade_acao.
     *
     * @param id the id of the perfil_funcionalidade_acao to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the perfil_funcionalidade_acao, or with status 404 (Not Found)
     */
    @GetMapping("/perfil-funcionalidade-acaos/{id}")
    @Timed
    public ResponseEntity<Perfil_funcionalidade_acao> getPerfil_funcionalidade_acao(@PathVariable Long id) {
        log.debug("REST request to get Perfil_funcionalidade_acao : {}", id);
        Perfil_funcionalidade_acao perfil_funcionalidade_acao = perfil_funcionalidade_acaoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(perfil_funcionalidade_acao));
    }

    /**
     * DELETE  /perfil-funcionalidade-acaos/:id : delete the "id" perfil_funcionalidade_acao.
     *
     * @param id the id of the perfil_funcionalidade_acao to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/perfil-funcionalidade-acaos/{id}")
    @Timed
    public ResponseEntity<Void> deletePerfil_funcionalidade_acao(@PathVariable Long id) {
        log.debug("REST request to delete Perfil_funcionalidade_acao : {}", id);
        perfil_funcionalidade_acaoService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/perfil-funcionalidade-acaos?query=:query : search for the perfil_funcionalidade_acao corresponding
     * to the query.
     *
     * @param query the query of the perfil_funcionalidade_acao search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/perfil-funcionalidade-acaos")
    @Timed
    public ResponseEntity<List<Perfil_funcionalidade_acao>> searchPerfil_funcionalidade_acaos(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of Perfil_funcionalidade_acaos for query {}", query);
        Page<Perfil_funcionalidade_acao> page = perfil_funcionalidade_acaoService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/perfil-funcionalidade-acaos");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

}
