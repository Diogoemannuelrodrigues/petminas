package io.github.com.petminas.controller;

import io.github.com.petminas.entidade.Pessoa;
import io.github.com.petminas.entidade.records.PessoaRecord;
import io.github.com.petminas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> salvarCliente(@RequestBody PessoaRecord pessoaRecord){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarCliente(pessoaRecord));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagarCliente(@PathVariable Integer id) {
        this.pessoaService.deletarCliente(id);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Pessoa>> getCliente(@PathVariable Integer id) {
         return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.getCliente(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pessoa> editarCliente(@PathVariable Integer id,
                                                @RequestBody PessoaRecord pessoaRecord) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pessoaService.editarCliente(id, pessoaRecord));
    }
}
