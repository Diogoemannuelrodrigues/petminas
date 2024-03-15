package io.github.com.petminas.entidade;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nome;

    private String cpf;

    @OneToMany(mappedBy = "pessoa")
    private List<Pet> pets;

    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    private String email;

}

