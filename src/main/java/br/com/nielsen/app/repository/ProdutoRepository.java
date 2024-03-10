package br.com.nielsen.app.repository;

import br.com.nielsen.app.domain.entity.Produto;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface ProdutoRepository extends ListCrudRepository<Produto, BigInteger> {
}
