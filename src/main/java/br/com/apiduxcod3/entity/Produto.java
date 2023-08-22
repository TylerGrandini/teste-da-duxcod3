package br.com.apiduxcod3.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private BigDecimal valor;

    @Column
    private String descricao;
}