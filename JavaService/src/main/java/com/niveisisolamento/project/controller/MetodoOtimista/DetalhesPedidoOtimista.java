package com.niveisisolamento.project.controller.MetodoOtimista;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

import com.niveisisolamento.project.model.Pedidos;

import jakarta.persistence.CascadeType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_detalhes_pedido_otimista")
public class DetalhesPedidoOtimista {



    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer detalhePedidoID;
    private double precoVenda;
    private Integer quantidade;
    private Double desconto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Pedidos pedidoID;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private ProdutoOtimista produtoID;




}