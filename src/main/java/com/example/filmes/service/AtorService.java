package com.example.filmes.service;
import com.example.filmes.dominio.Ator;
import com.example.filmes.repository.AtorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AtorService {
    private AtorRepository atorRepository;

    public Ator adicionaAtor(Ator ator) {
        return atorRepository.save(ator);
    }

    public List<Ator> listarAtores() {
        return atorRepository.findAll();
    }

    public Ator buscaPorId(Long id) {
        Optional<Ator> AtorOptional = atorRepository.findById(id);
        if (AtorOptional.isEmpty()) {
            throw new IllegalArgumentException("Id não é valido");
        }
        return AtorOptional.get();
    }

    public Ator buscaPorNome(String nome) {
        Optional<Ator> AtorOptional = atorRepository.findByNome(nome);
        if (AtorOptional.isEmpty()) {
            throw new IllegalArgumentException("Nome não é valido");
        }
        return AtorOptional.get();
    }

    public Ator removeAtor(Long id) {
        Ator ator = this.buscaPorId(id);
        atorRepository.delete(ator);
        return ator;
    }

    public Ator atualizaAtor(Ator novoAtor) {
        Ator atorBanco = this.buscaPorId(novoAtor.getId());
        atorBanco.setNome(atorBanco.getNome());

        return this.adicionaAtor(atorBanco);
    }
}
