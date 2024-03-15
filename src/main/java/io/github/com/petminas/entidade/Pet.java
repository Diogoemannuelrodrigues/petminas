package io.github.com.petminas.entidade;

import io.github.com.petminas.entidade.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String raca;

    private Integer idade;

    @Enumerated(EnumType.STRING)
    private GeneroEnum generoEnum;

    @ManyToOne
    private Pessoa pessoa;

}