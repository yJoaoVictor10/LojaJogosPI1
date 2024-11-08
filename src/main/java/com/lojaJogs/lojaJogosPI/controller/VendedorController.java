package com.lojaJogs.lojaJogosPI.controller;

import com.lojaJogs.lojaJogosPI.model.ClienteEntity;
import com.lojaJogs.lojaJogosPI.model.VendedorEntity;
import com.lojaJogs.lojaJogosPI.service.VendedorService;
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

@RequestMapping("/vendedor")
public class VendedorController {
    
    @Autowired
    VendedorService vendedorService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<VendedorEntity> addVendedor(@Valid @RequestBody VendedorEntity vend){
        
        var novoVendedor = vendedorService.criarVendedor(vend);
        
        return new ResponseEntity<>(novoVendedor, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllVendedor(){
        
        List<VendedorEntity> vendedores = vendedorService.listarVendedores();
        
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<VendedorEntity> atualizarVendedor(@PathVariable Integer id, @RequestBody VendedorEntity vend){
        
        var vendedorAtualizado = vendedorService.atualizarVendedor(id, vend);
        
        return new ResponseEntity<>(vendedorAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarVendedor(@PathVariable Integer id){
        
        vendedorService.deletarVendedor(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
