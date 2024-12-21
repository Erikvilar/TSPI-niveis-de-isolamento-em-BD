package com.niveisisolamento.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto")
public class Produto {
    

    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Integer produtoID;
    private String produtoNome;
    private Integer categoriaID;
    private Double preco;
    private Integer unidadeEmEstoque;
    private String imagem;
}
