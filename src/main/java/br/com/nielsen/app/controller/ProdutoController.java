package br.com.nielsen.app.controller;

import br.com.nielsen.app.domain.dto.ProdutoDTO;
import br.com.nielsen.app.domain.entity.Produto;
import br.com.nielsen.app.domain.requests.RequestProduto;
import br.com.nielsen.app.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listaProdutos() {

        try {
            ModelMapper modelMapper = new ModelMapper();

            List<Produto> produtos = produtoService.listarProdutos();

            List<ProdutoDTO> produtosDTO = produtos.stream()
                    .map(produto -> {
                        return modelMapper.map(produto, ProdutoDTO.class);
                    })
                    .toList();

            if (produtosDTO.isEmpty()) {
                return ResponseEntity
                        .of(ProblemDetail
                                .forStatusAndDetail(HttpStatusCode.valueOf(HttpStatus.NO_CONTENT.value()),
                                        "Records not found."))
                        .build();
            }

            return ResponseEntity.ok(produtosDTO);

        } catch(Exception ex) {
            System.out.println("[ERROR] - " + ex.getMessage());

            return ResponseEntity
                    .of(ProblemDetail
                            .forStatusAndDetail(HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                                    "Internal Server Error."))
                    .build();
        }
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Validated(ProdutoDTO.class) ProdutoDTO produtoDTO ) {

        System.out.println(produtoDTO);

        try {
            ModelMapper modelMapper = new ModelMapper();
            Produto produto = modelMapper.map(produtoDTO, Produto.class);

            ProdutoDTO novoProduto = modelMapper.map(produtoService.salvar(produto), ProdutoDTO.class);

            if (novoProduto == null) {
                throw new Exception("Failed to save product registration.");
            }

            return ResponseEntity.ok(novoProduto);

        } catch (Exception ex) {
            System.out.println("[ERROR] - " + ex.getMessage());

            return ResponseEntity
                    .of(ProblemDetail
                            .forStatusAndDetail(HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                                    ex.getMessage()))
                    .build();

        }
    }
}

