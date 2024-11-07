package com.lojaJogs.lojaJogosPI.service;

import com.lojaJogs.lojaJogosPI.model.VendedorEntity;
import com.lojaJogs.lojaJogosPI.model.VendedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {
    
    @Autowired 
    VendedorRepository vendedorRepository;
    
    public VendedorEntity criarVendedor(VendedorEntity vend){
        vend.setIdVend(null);
        vendedorRepository.save(vend);
        return vend;
    }
    
    public VendedorEntity getVendedorId(Integer vendId){
        return vendedorRepository.findById(vendId).orElse(null);
    }
    
    public List<VendedorEntity> listarVendedores(){
        return vendedorRepository.findAll();
    }
    
    public VendedorEntity atualizarVendedor(Integer vendId, VendedorEntity vendedorRequest){
        VendedorEntity vend = getVendedorId(vendId);
        
        vend.setNomeVend(vendedorRequest.getNomeVend());
        
        vend.setIdadeVend(vendedorRequest.getIdadeVend());
        
        vend.setCpfVend(vendedorRequest.getCpfVend());
        
        vend.setValorHora(vendedorRequest.getValorHora());
        
        vend.setHorasTrabalhadas(vendedorRequest.getHorasTrabalhadas());
        
        vendedorRepository.save(vend);
        
        return vend;
    }
    
    public void deletarVendedor(Integer vendId){
        VendedorEntity vend = getVendedorId(vendId);
        
        vendedorRepository.deleteById(vend.getIdVend());
    }
}
