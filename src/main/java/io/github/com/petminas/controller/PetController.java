package io.github.com.petminas.controller;

import io.github.com.petminas.entidade.Pet;
import io.github.com.petminas.entidade.records.PetRecord;
import io.github.com.petminas.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<Pet> salvarPet(@RequestBody PetRecord petRecord){
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.salvarPet(petRecord));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable Integer id) {
        this.petService.deletarPet(id);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pet> get(@PathVariable Integer id) {
         return ResponseEntity.status(HttpStatus.OK).body(this.petService.getPet(id));
    }
}
