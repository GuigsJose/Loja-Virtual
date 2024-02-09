package com.br.services;

import com.br.entities.Produto;
import com.br.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto cadastrar(String nome, String descricao, double preco, int estoque){
        var produto = new Produto();

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setEstoque(estoque);

        return repository.save(produto);
    }

}
