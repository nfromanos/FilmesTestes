package com.example.filmes.repository;
import com.example.filmes.dominio.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
