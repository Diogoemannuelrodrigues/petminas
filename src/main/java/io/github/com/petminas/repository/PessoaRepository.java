package io.github.com.petminas.repository;

import io.github.com.petminas.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByNome(String nome);
}
