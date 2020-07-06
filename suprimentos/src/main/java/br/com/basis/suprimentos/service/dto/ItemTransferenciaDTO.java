package br.com.basis.suprimentos.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ItemTransferenciaDTO implements Serializable {
    private Long id;

    @NotNull
    private Integer quantidadeEnvidada;
}