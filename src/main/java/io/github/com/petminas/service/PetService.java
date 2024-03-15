package io.github.com.petminas.service;

import io.github.com.petminas.entidade.Pet;
import io.github.com.petminas.entidade.records.PessoaRecord;
import io.github.com.petminas.entidade.records.PetRecord;
import io.github.com.petminas.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet salvarPet(PetRecord petRecord) {
        Pet pessoaResult = petRepository.findByNome(petRecord.nome());
        if (pessoaResult != null) {
            throw new IllegalArgumentException("Pet '" + petRecord.nome() + "' já cadastrada.");
        }
        Pet pet = new Pet();
        BeanUtils.copyProperties(petRecord, pet);
        return petRepository.save(pet);
    }

    public void deletarPet(Integer id){
        var result = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nao existe para esse id"));
        petRepository.delete(result);
    }



    public Pet editarPet(PetRecord petRecord){
        Pet pet = new Pet();
        var resultPet = petRepository.findById(petRecord.id())
                .orElseThrow(() -> new IllegalArgumentException("Pet nao encontrada"));
        BeanUtils.copyProperties(pet, petRecord);
        return this.petRepository.save(pet);
    }

    public Pet getPet(Integer id){
        return petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet nao encontrada"));
    }
}
