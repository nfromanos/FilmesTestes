package com.example.filmes.controller;
import com.example.filmes.dominio.Ator;
import com.example.filmes.service.AtorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
@AllArgsConstructor
public class AtorController {
    private final AtorService atorService;

    @PostMapping
    public ResponseEntity<Ator> adicionaAtor(@RequestBody Ator ator) {
        atorService.adicionaAtor(ator);
        return new ResponseEntity<>(ator, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ator> buscaAtorPorId(@PathVariable Long id) {
        Ator ator = atorService.buscaPorId(id);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Ator> buscaAtorPorId(@PathVariable String nome) {
        Ator ator = atorService.buscaPorNome(nome);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Ator> atualizaAtor(@RequestBody Ator novoAtor) {
        Ator ator = atorService.atualizaAtor(novoAtor);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Ator>> listarAtores() {
        List<Ator> listaAtores = atorService.listarAtores();
        return new ResponseEntity<>(listaAtores, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ator> removerAtor(@PathVariable Long id) {
        Ator ator = atorService.removeAtor(id);
        return new ResponseEntity<>(ator, HttpStatus.OK);
    }
}
