package com.example.filmes.dominio;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String genero;
    @NotBlank
    private Date dataDeLancamento;
    @OneToMany
    private List<Ator> listaAtores;


}
