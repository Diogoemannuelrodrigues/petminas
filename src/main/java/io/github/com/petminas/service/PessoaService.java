package io.github.com.petminas.service;

import io.github.com.petminas.entidade.Pessoa;
import io.github.com.petminas.entidade.records.PessoaRecord;
import io.github.com.petminas.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa salvarCliente(PessoaRecord pessoaRecord) {
        Pessoa pessoaResult = pessoaRepository.findByNome(pessoaRecord.nome());
        if (pessoaResult != null) {
            throw new IllegalArgumentException("Cliente '" + pessoaRecord.nome() + "' já cadastrada.");
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaRecord, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public void deletarCliente(Integer id){
        var result = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nao existe para esse id"));
        pessoaRepository.delete(result);
    }

    public Pessoa editarCliente(Integer id, PessoaRecord pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + id));
        BeanUtils.copyProperties(pessoaAtualizada, pessoaExistente, "id");
        return pessoaRepository.save(pessoaExistente);
    }
    @Transactional(readOnly = true)
    public Optional<Pessoa> getCliente(Integer id){
        return pessoaRepository.findById(id);
    }
}
