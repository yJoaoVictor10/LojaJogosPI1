package com.lojaJogs.lojaJogosPI.controller;

import com.lojaJogs.lojaJogosPI.model.JogoEntity;
import com.lojaJogs.lojaJogosPI.service.JogoService;
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

@RequestMapping("/jogo")
public class JogoController {
    
    
    @Autowired
    JogoService jogoService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<JogoEntity> addJogo(@Valid @RequestBody JogoEntity jogo){
        
        var novoJogo = jogoService.criarJogo(jogo);
        
        return new ResponseEntity<>(novoJogo, HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List> getAllJogo(){
        
        List<JogoEntity> jogos = jogoService.listarJogos();
        
        return new ResponseEntity<>(jogos, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<JogoEntity> atualizarJogo(@PathVariable Integer id, @RequestBody JogoEntity jogo){
        
        var jogoAtualizado = jogoService.atualizarJogo(id, jogo);
        
        return new ResponseEntity<>(jogoAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarJogo(@PathVariable Integer id){
        
        jogoService.deletarJogo(id);
        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
