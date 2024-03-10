package br.com.nielsen.app.domain.dto;

import br.com.nielsen.app.domain.entity.CustomLocalDateTimeSerializer;
import br.com.nielsen.app.domain.entity.ParseDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
public class ProdutoDTO implements Serializable {

    private BigInteger id;

    @Column(nullable = false, length = 255)
    private String nome;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = ParseDeserializer.class)
    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @Column(nullable = false)
    private BigDecimal preco;

}
