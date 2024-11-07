package com.lojaJogs.lojaJogosPI.service;

import com.lojaJogs.lojaJogosPI.model.ClienteEntity;
import com.lojaJogs.lojaJogosPI.model.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired 
    ClienteRepository clienteRepository;
    
    public ClienteEntity criarCliente(ClienteEntity cli){
        cli.setId(null);
        clienteRepository.save(cli);
        return cli;
    }
    
    public ClienteEntity getClienteId(Integer clienteId){
        return clienteRepository.findById(clienteId).orElse(null);
    }
    
    public List<ClienteEntity> listarClientes(){
        return clienteRepository.findAll();
    }
    
    public ClienteEntity atualizarCliente(Integer cliId, ClienteEntity clienteRequest){
        ClienteEntity cli = getClienteId(cliId);
        
        cli.setNomeCli(clienteRequest.getNomeCli());
        
        cli.setIdadeCli(clienteRequest.getIdadeCli());
        
        cli.setCpfCli(clienteRequest.getCpfCli());
        
        cli.setTelefoneCli(clienteRequest.getTelefoneCli());
        
        cli.setEmailCli(clienteRequest.getEmailCli());
        
        clienteRepository.save(cli);
        
        return cli;
    }
    
    public void deletarCliente(Integer cliId){
        ClienteEntity cli = getClienteId(cliId);
        
        clienteRepository.deleteById(cli.getId());
    }
}
