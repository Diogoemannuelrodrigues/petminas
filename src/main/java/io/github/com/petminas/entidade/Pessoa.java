package io.github.com.petminas.entidade;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NonNull;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Pessoa {

    private Integer id;

    @NonNull
    private String nome;

    private String cpf;

    @OneToMany(mappedBy = "cliente")
    private List<Pet> pets;

    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    private String email;

}
