package com.niveisisolamento.project.service.DTO;

import com.niveisisolamento.project.controller.MetodoOtimista.DetalhesPedidoOtimista;
import com.niveisisolamento.project.controller.MetodoOtimista.ProdutoOtimista;
import com.niveisisolamento.project.model.ClientesUser;
import com.niveisisolamento.project.model.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalhePedidoOtimistaDTO {
    private Integer detalhePedidoID;
    private double precoVenda;
    private Integer quantidade;
    private Double desconto;
    private Pedidos pedidosID;
    private ProdutoOtimista produtoID;

    public DetalhePedidoOtimistaDTO toDTO(DetalhesPedidoOtimista detalhesPedido){
        return new DetalhePedidoOtimistaDTO(
            detalhesPedido.getDetalhePedidoID(),
            detalhesPedido.getPrecoVenda(),
            detalhesPedido.getQuantidade(),
            detalhesPedido.getDesconto(),
            detalhesPedido.getPedidoID(),
            detalhesPedido.getProdutoID());
    }

}
