package io.github.com.petminas.repository;

import io.github.com.petminas.entidade.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Pet findByNome(String nome);
}
