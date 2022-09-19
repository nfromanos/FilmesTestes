package com.example.filmes.repository;
import com.example.filmes.dominio.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Optional<Filme> findByNome(String nome);
    Optional<List<Filme>> findByGenero(String genero);
    Optional<List<Filme>> findByDataDeLancamento(String ano);
}
