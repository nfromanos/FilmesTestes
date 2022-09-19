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
    public ResponseEntity<Filme> adicionaRemedio(@RequestBody Filme filme) {
        Filme filmeAdicionado = filmeService.adicionaFilme(filme);
        return new ResponseEntity<>(filmeAdicionado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscaRemedioPorId(@PathVariable Long id) {
        Filme remedio = filmeService.buscaPorId(id);
        return new ResponseEntity<>(remedio, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Filme> atualizaFilme(@RequestBody Filme novoFilme) {
        Filme filme = filmeService.atualizaFilme(novoFilme);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarRemedios() {
        List<Filme> listaFilmes = filmeService.listarFilmes();
        return new ResponseEntity<>(listaFilmes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> removerRemedio(@PathVariable Long id) {
        Filme filme = filmeService.removeFilme(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

}
