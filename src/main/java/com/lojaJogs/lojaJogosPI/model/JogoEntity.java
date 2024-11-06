package com.lojaJogs.lojaJogosPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "Jogo")
public class JogoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idJogo;
    
    @NotNull(message = "Nome do jogo obrigatório")
    private String nomeJogo;
    
    @NotNull(message = "Valor do jogo obrigatório")
    private double valorJogo;
    
    @NotNull(message = "Gênero do jogo obrigatório")
    private String generoJogo;
    
    @NotNull(message = "Classificação etária do jogo obrigatória")
    private String clasEtariaJogo;
    
}
