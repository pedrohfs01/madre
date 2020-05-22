package br.com.basis.madre.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrmDTO implements Serializable {

    private Long id;

    @NotNull
    private Long codigo;

    @NotNull
    private String nome;

}
