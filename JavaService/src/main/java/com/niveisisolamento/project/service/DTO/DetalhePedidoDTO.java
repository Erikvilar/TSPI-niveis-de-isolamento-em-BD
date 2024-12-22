package com.niveisisolamento.project.service.DTO;


import com.niveisisolamento.project.model.ClientesUser;
import com.niveisisolamento.project.model.DetalhesPedido;
import com.niveisisolamento.project.model.Pedidos;
import com.niveisisolamento.project.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetalhePedidoDTO {
    private Integer detalhePedidoID;
    private double precoVenda;
    private Integer quantidade;
    private Double desconto;
    private ClientesUser clienteID;
    private Pedidos pedidosID;
    private Produto produtoID;

    public DetalhePedidoDTO toDTO(DetalhesPedido detalhesPedido, ClientesUser clientesUser){
        return new DetalhePedidoDTO(
            detalhesPedido.getDetalhePedidoID(),
            detalhesPedido.getPrecoVenda(),
            detalhesPedido.getQuantidade(),
            detalhesPedido.getDesconto(),
            detalhesPedido.getPedidoID().getClienteID(),
            detalhesPedido.getPedidoID(),
            detalhesPedido.getProdutoID());
    }

}
