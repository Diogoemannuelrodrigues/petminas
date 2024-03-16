package io.github.com.petminas.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
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

    @CPF
    @NonNull
    private String cpf;

    @OneToMany(mappedBy = "pessoa")
    private List<Pet> pets = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    @Email
    private String email;

    private Boolean aceite;

}

