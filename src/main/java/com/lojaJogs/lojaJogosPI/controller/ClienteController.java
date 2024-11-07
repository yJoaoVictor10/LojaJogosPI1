package com.lojaJogs.lojaJogosPI.controller;

import com.lojaJogs.lojaJogosPI.model.ClienteEntity;
import com.lojaJogs.lojaJogosPI.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/cliente")

public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteEntity> addCliente(@Valid @RequestBody ClienteEntity cli){
        
        var novoCliente = clienteService.criarCliente(cli);
        
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllCliente(){
        
        List<ClienteEntity> clientes = clienteService.listarClientes();
        
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteEntity> atualizarCliente(@PathVariable Integer id, @RequestBody ClienteEntity cli){
        
        var clienteAtualizado = clienteService.atualizarCliente(id, cli);
        
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarFuncionario(@PathVariable Integer id){
        
        clienteService.deletarCliente(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
