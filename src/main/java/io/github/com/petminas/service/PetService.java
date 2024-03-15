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
            throw new IllegalArgumentException("Pessoa '" + petRecord.nome() + "' já cadastrada.");
        }
        Pet pet = new Pet();
        BeanUtils.copyProperties(petRecord, pet);
        return petRepository.save(pet);
    }

    public void deletarPet(PetRecord petRecord){
        var result = petRepository.findByNome(petRecord.nome());
        if (result == null){
            throw new IllegalArgumentException("Nao existe pessoa - "+petRecord.nome()+" com esse nome.");
        }
        petRepository.delete(result);
    }

    public Pet editarPet(PetRecord petRecord){
        Pet pet = new Pet();
        var resultPet = petRepository.findById(petRecord.id())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa nao encontrada"));
        BeanUtils.copyProperties(pet, petRecord);
        return this.petRepository.save(pet);
    }

    public Pet getPet(String name){
        return petRepository.findByNome(name);
    }
}
