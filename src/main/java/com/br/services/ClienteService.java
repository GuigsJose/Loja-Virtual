package com.br.services;

import com.br.entities.Cliente;
import com.br.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorEmail(String email){
        return clienteRepository.findByEmail(email);
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(Long id, String nome, String cpf){
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()){
            var cliente = clienteExistente.get();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            return clienteRepository.save(cliente);
        }
        else {
            return null;
        }
    }

}
