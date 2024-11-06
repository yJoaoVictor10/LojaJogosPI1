package com.lojaJogs.lojaJogosPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "Cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull(message = "Nome do cliente obrigatório")
    private String nomeCli;
    
    @NotNull(message = "Idade do cleinte obrigatória")
    private String idadeCli;
    
    @NotNull(message = "CPF do cliente obrigatório")
    @CPF(message = "Colocar o CPF no formato correto")
    private String cpfCli;
    
    @NotBlank(message = "Telefone do cliente obrigatório")
    private String telefoneCli;
    
    @NotBlank(message = "Email do cliente obrigatório")
    @Email(message = "Colocar o email no formato correto")
    private String emailCli;

}
