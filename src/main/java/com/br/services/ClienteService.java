package com.br.services;

import com.br.entities.Cliente;
import com.br.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(String nome, String email, String cpf, String endereco, String senha){
        var cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setNome(cpf);
        cliente.setNome(endereco);
        cliente.setSenha(senha);

        return clienteRepository.save(cliente);
    }
}
