package br.com.nielsen.app.domain.requests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RequestProduto(String nome, LocalDateTime dataCadastro, BigDecimal preco) {
}
