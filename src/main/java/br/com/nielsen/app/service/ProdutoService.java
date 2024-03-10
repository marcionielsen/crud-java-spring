package br.com.nielsen.app.service;

import br.com.nielsen.app.domain.entity.Produto;
import br.com.nielsen.app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {

        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {

        Produto novoProduto = produtoRepository.save(produto);

        return novoProduto;
    }

}
