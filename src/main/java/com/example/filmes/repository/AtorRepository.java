package com.example.filmes.repository;
import com.example.filmes.dominio.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AtorRepository extends JpaRepository<Ator, Long> {
    Optional<Ator> findByNome(String nome);
}
