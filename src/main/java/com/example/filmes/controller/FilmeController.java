package com.example.filmes.controller;
import com.example.filmes.dominio.Filme;
import com.example.filmes.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/filmes")
@AllArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Filme> adicionaFilme(@RequestBody Filme filme) {
        Filme filmeAdicionado = filmeService.adicionaFilme(filme);
        return new ResponseEntity<>(filmeAdicionado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscaFilmePorId(@PathVariable Long id) {
        Filme filme = filmeService.buscaPorId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Filme> buscaFilmePorNome(@PathVariable String nome) {
        Filme filme = filmeService.buscaPorNome(nome);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping("/{genero}")
    public ResponseEntity<Filme> buscaFilmePorGenero(@PathVariable String genero) {
        List<Filme> filme = filmeService.buscaPorGenero(genero);
        return new ResponseEntity<>(filme.get(0), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscaFilmePorAnoLancamento(@PathVariable String ano) {
        List<Filme> filme = filmeService.buscaPorAno(ano);
        return new ResponseEntity<>(filme.get(0), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Filme> atualizaFilme(@RequestBody Filme novoFilme) {
        Filme filme = filmeService.atualizaFilme(novoFilme);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> listaFilmes = filmeService.listarFilmes();
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> removerFilme(@PathVariable Long id) {
        Filme filme = filmeService.removeFilme(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

}
