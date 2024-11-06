package com.lojaJogs.lojaJogosPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "Vendedor")
public class VendedorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVend;
    
    @NotNull(message = "Nome do vendedor obrigatório")
    private String nomeVend;
    
    @NotNull(message = "Idade do vendedor obrigatória")
    private String idadeVend;
    
    @NotNull(message = "CPF do vendedor obrigatório")
    @CPF(message = "Colocar o CPF no formato correto")
    private String cpfVend;
    
    @NotBlank(message = "Valor da hora do vendedor obrigatório")
    private String valorHora;
    
    @NotBlank(message = "Horas trabalhadas do vendedor obrigatório")
    private String horasTrabalhadas;
}
