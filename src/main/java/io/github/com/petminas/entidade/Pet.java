package io.github.com.petminas.entidade;

import io.github.com.petminas.entidade.enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private Integer id;

    private String nome;

    private String raca;

    private Integer idade;

    private GeneroEnum generoEnum;

    private Pessoa dono;

}