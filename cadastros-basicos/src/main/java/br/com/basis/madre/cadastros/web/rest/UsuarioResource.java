package br.com.basis.madre.cadastros.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import br.com.basis.madre.cadastros.domain.Usuario;
import br.com.basis.madre.cadastros.service.UsuarioService;
import br.com.basis.madre.cadastros.service.dto.UsuarioDTO;
import br.com.basis.madre.cadastros.service.exception.RelatorioException;
import br.com.basis.madre.cadastros.service.exception.UsuarioException;
import br.com.basis.madre.cadastros.web.rest.errors.BadRequestAlertException;
import br.com.basis.madre.cadastros.web.rest.util.HeaderUtil;
import br.com.basis.madre.cadastros.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;

//import org.h2.engine.User;

/**
 * REST controller for managing Usuario.
 */
@RestController
@RequestMapping("/api")
public class UsuarioResource {

    private final Logger log = LoggerFactory.getLogger(UsuarioResource.class);

    private static final String ENTITY_NAME = "usuario";

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * POST  /usuarios : Create a new usuario.
     *
     * @param usuarioDTO the usuario to create
     * @return the ResponseEntity with status 201 (Created) and with body the new usuario, or with status 400 (Bad Request) if the usuario has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/usuarios")
    @Timed
    public ResponseEntity<UsuarioDTO> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO)
        throws URISyntaxException {
//        try {
//            log.debug("REST request to save Usuario : {}", usuarioDTO);
//            if (usuarioDTO.getId() != null) {
//                throw new BadRequestAlertException("A new usuario cannot already have an ID", ENTITY_NAME, "idexists");
//            }
//            UsuarioDTO result = usuarioService.save(usuarioDTO);
//            return ResponseEntity.created(new URI("/api/usuarios/" + result.getId()))
//                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
//                .body(result);
//        } catch (UsuarioException e) {
//            log.error(e.getMessage(), e);
//            return ResponseEntity.badRequest()
//                .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, UsuarioException.getCodeRegistroExisteBase(), e.getMessage()))
//                .body(usuarioDTO);
//        }     mexer aqui, duplicidade
            log.debug("REST request to save Usuario : {}", usuarioDTO);
            if (usuarioDTO.getId() != null) {
                throw new BadRequestAlertException("A new usuario cannot already have an ID", ENTITY_NAME, "idexists");
            }
            UsuarioDTO result = usuarioService.save(usuarioDTO);
            return ResponseEntity.created(new URI("/api/usuarios/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    /**
     * PUT  /usuarios : Updates an existing usuario.
     *
     * @param usuarioDTO the usuario to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated usuario,
     * or with status 400 (Bad Request) if the usuario is not valid,
     * or with status 500 (Internal Server Error) if the usuario couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/usuarios")
    @Timed
    public ResponseEntity<UsuarioDTO> updateUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO)
        throws URISyntaxException {
        log.debug("REST request to update Usuario : {}", usuarioDTO);
//        try {
//            log.debug("REST request to update UnidadeHospitalar : {}", usuarioDTO);
//            if (usuarioDTO.getId() == null) {
//                return createUsuario(usuarioDTO);
//            }
//            UsuarioDTO result = usuarioService.save(usuarioDTO);
//            return ResponseEntity.ok()
//                .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, usuarioDTO.getId().toString()))
//                .body(result);
//        } catch (UsuarioException e) {
//            log.error(e.getMessage(), e);
//            return ResponseEntity.badRequest()
//                .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, UsuarioException.getCodeRegistroExisteBase(), e.getMessage()))
//                .body(usuarioDTO);
//        }
        if (usuarioDTO.getId() == null) {
            return createUsuario(usuarioDTO);
        }
        UsuarioDTO result = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, usuarioDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /usuarios : get all the usuarios.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of usuarios in body
     */
    @GetMapping("/usuarios")
    @Timed
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(@RequestParam(value = "query") Optional<String> query,
        @ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Usuarios");
        Page<UsuarioDTO> page = usuarioService.findAll(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/usuarios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /usuarios/:id : get the "id" usuario.
     *
     * @param id the id of the usuario to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the usuario, or with status 404 (Not Found)
     */
    @GetMapping("/usuarios/{id}")
    @Timed
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Long id) {
        log.debug("REST request to get Usuario : {}", id);
        UsuarioDTO usuarioDTO = usuarioService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(usuarioDTO));
    }

    /**
     * DELETE  /usuarios/:id : delete the "id" usuario.
     *
     * @param id the id of the usuario to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/usuarios/{id}")
    @Timed
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        log.debug("REST request to delete Usuario : {}", id);
        usuarioService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * SEARCH  /_search/usuarios?query=:query : search for the usuario corresponding
     * to the query.
     *
     * @param query the query of the usuario search
     * @param pageable the pagination information
     * @return the result of the search
     */
    @GetMapping("/_search/usuarios")
    @Timed
    public ResponseEntity<List<UsuarioDTO>> searchUsuarios(@RequestParam(defaultValue = "*") String query,
        Pageable pageable) {
        // query="\""+query+"\"";
        log.debug("REST request to search for a page of Usuarios for query {}", query);
        Page<UsuarioDTO> page = usuarioService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generateSearchPaginationHttpHeaders(query, page, "/api/_search/usuarios");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /usuarios/:id : get jasper of  usuarios.
     *
     * @param tipoRelatorio
     * @return the ResponseEntity with status 200 (OK)
     */
    @GetMapping(value = "/usuario/exportacao/{tipoRelatorio}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @Timed
    public ResponseEntity<InputStreamResource> getRelatorioExportacao(@PathVariable String tipoRelatorio) {
        try {
            return usuarioService.gerarRelatorioExportacao(tipoRelatorio);
        } catch (RelatorioException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, RelatorioException.getCodeEntidade(), e.getMessage())).body(null);
        }
    }
}
