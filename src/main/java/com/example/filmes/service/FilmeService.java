package com.example.filmes.service;
import com.example.filmes.Exceptions.filmeNotFoundException;
import com.example.filmes.dominio.Filme;
import com.example.filmes.repository.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FilmeService {
    private final FilmeRepository filmeRepository;

    public Filme adicionaFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme buscaPorId(Long id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);
        if (filmeOptional.isEmpty()) {
            throw new filmeNotFoundException("Id não é valido");
        }
        return filmeOptional.get();
    }

    public Filme buscaPorNome(String nome) {
        Optional<Filme> filmeOptional = filmeRepository.findByNome(nome);
        if (filmeOptional.isEmpty()) {
            throw new filmeNotFoundException("Nome não é valido");
        }
        return filmeOptional.get();
    }

    public List<Filme> buscaPorGenero(String genero) {
        Optional<List<Filme>> filmeOptional = filmeRepository.findByGenero(genero);
        if (filmeOptional.isEmpty()) {
            throw new filmeNotFoundException("Genero não é valido");
        }
        return filmeOptional.get();
    }

    public List<Filme> buscaPorAno(String ano) {
        Optional<List<Filme>> filmeOptional = filmeRepository.findByDataDeLancamento(ano);
        if (filmeOptional.isEmpty()) {
            throw new filmeNotFoundException("Ano não é valido");
        }
        return filmeOptional.get();
    }

    public Filme removeFilme(Long id) {
        Filme filme = this.buscaPorId(id);
        filmeRepository.delete(filme);
        return filme;
    }

    public Filme atualizaFilme(Filme novoFilme) {
        Filme filmeBanco = this.buscaPorId(novoFilme.getId());

        filmeBanco.setNome(novoFilme.getNome());
        filmeBanco.setGenero(novoFilme.getGenero());
        filmeBanco.setDataDeLancamento(novoFilme.getDataDeLancamento());
        filmeBanco.setListaAtores(novoFilme.getListaAtores());
        return this.adicionaFilme(filmeBanco);
    }
}
