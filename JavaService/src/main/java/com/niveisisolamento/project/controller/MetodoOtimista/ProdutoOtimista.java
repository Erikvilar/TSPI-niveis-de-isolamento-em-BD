package com.niveisisolamento.project.controller.MetodoOtimista;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_produto_pessimista")
public class ProdutoOtimista {
    
    @Id
    @GeneratedValue(strategy = IDENTITY )
    private Integer produtoID;
    private String produtoNome;
    private Double preco;
    private Integer unidadeEmEstoque;
    private String imagem;
    private Integer categoriaID;


    @Version
    private Integer version;


}