package br.com.basis.madre.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import br.com.basis.madre.domain.enumeration.TipoDoContato;

/**
 * A DTO for the {@link br.com.basis.madre.domain.Telefone} entity.
 */
public class TelefoneDTO implements Serializable {
    
    private Long id;

    @NotNull
    private String ddd;

    @NotNull
    private String numero;

    private TipoDoContato tipo;

    private String observacao;


    private Long pacienteId;

    private Long responsavelId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoContato tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Long responsavelId) {
        this.responsavelId = responsavelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TelefoneDTO telefoneDTO = (TelefoneDTO) o;
        if (telefoneDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), telefoneDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TelefoneDTO{" +
            "id=" + getId() +
            ", ddd='" + getDdd() + "'" +
            ", numero='" + getNumero() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", observacao='" + getObservacao() + "'" +
            ", pacienteId=" + getPacienteId() +
            ", responsavelId=" + getResponsavelId() +
            "}";
    }
}