package io.github.com.petminas.service;

import io.github.com.petminas.entidade.Pessoa;
import io.github.com.petminas.entidade.records.PessoaRecord;
import io.github.com.petminas.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(PessoaRecord pessoaRecord) {
        Pessoa pessoaResult = pessoaRepository.findByNome(pessoaRecord.nome());
        if (pessoaResult != null) {
            throw new IllegalArgumentException("Pessoa '" + pessoaRecord.nome() + "' já cadastrada.");
        }
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoa, pessoaRecord);
        return pessoaRepository.save(pessoa);
    }

    public void deletarPessoa(PessoaRecord pessoaRecord){
        var result = pessoaRepository.findByNome(pessoaRecord.nome());
        if (result == null){
            throw new IllegalArgumentException("Nao existe pessoa - "+pessoaRecord.nome()+" com esse nome.");
        }
        pessoaRepository.delete(result);
    }

    public Pessoa editarPessoa(PessoaRecord pessoaRecord){
        Pessoa pessoa = new Pessoa();
        var resultPessoa = pessoaRepository.findById(pessoaRecord.id())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa nao encontrada"));
        BeanUtils.copyProperties(pessoa, pessoaRecord);
        return this.pessoaRepository.save(pessoa);
    }

    public Pessoa getPessoa(String name){
        return pessoaRepository.findByNome(name);
    }
}
