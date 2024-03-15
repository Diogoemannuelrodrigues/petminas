package io.github.com.petminas.controller;

import io.github.com.petminas.entidade.Pet;
import io.github.com.petminas.entidade.records.PetRecord;
import io.github.com.petminas.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<Pet> salvarPet(@RequestBody PetRecord petRecord){
        return ResponseEntity.ok().body(petService.salvarPet(petRecord));
    }
}
