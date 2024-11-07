package com.lojaJogs.lojaJogosPI.service;

import com.lojaJogs.lojaJogosPI.model.JogoEntity;
import com.lojaJogs.lojaJogosPI.model.JogoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    
    @Autowired 
    JogoRepository jogoRepository;
    
    public JogoEntity criarJogo(JogoEntity jogo){
        jogo.setIdJogo(null);
        jogoRepository.save(jogo);
        return jogo;
    }
    
    public JogoEntity getJogoId(Integer jogoId){
        return jogoRepository.findById(jogoId).orElse(null);
    }
    
    public List<JogoEntity> listarJogos(){
        return jogoRepository.findAll();
    }
    
    public JogoEntity atualizarJogo(Integer jogoId, JogoEntity jogoRequest){
        JogoEntity jogo = getJogoId(jogoId);
        
        jogo.setNomeJogo(jogoRequest.getNomeJogo());
        
        jogo.setValorJogo(jogoRequest.getValorJogo());
        
        jogo.setGeneroJogo(jogoRequest.getGeneroJogo());
        
        jogo.setClasEtariaJogo(jogoRequest.getClasEtariaJogo());
        
        jogoRepository.save(jogo);
        
        return jogo;
    }
    
    public void deletarJogo(Integer jogoId){
        JogoEntity jogo = getJogoId(jogoId);
        
        jogoRepository.deleteById(jogo.getIdJogo());
    }
}
