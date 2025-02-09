package com.niveisisolamento.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.CascadeType;

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
    private Double preco;
    private Integer unidadeEmEstoque;
    private String imagem;
    private Integer categoriaID;


}
